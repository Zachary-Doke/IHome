package com.ihome.service.Impl;

import com.ihome.dao.DeviceDao;
import com.ihome.pojo.AcPrefer;
import com.ihome.pojo.Device;
import com.ihome.pojo.EnvironmentData;
import com.ihome.pojo.LightPrefer;
import com.ihome.properties.AliIotConfigProperties;
import com.ihome.service.AcPreferService;
import com.ihome.service.DeviceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private AliIotConfigProperties aliIotConfigProperties;
    @Autowired
    private LightPreferServiceImpl lightPreferServiceImpl;
    @Autowired
    private AcPreferService acPreferServiceImpl;
    @Autowired
    private EnvironmentDataServiceImpl environmentDataServiceImpl;
    @Autowired
    private CommandServiceImpl commandServiceImpl;

    private final Lock lock = new ReentrantLock();

    @Override
    public Device addDevice(Device device) {
        return deviceDao.save(device);
    }

    @Override
    public Device saveDevice(Device device) {
        List<Device> deviceList = new ArrayList<>();
        int flag = 1;
        lock.lock();
        try {
            deviceList = getDeviceList(null);
            for (Device value : deviceList) {
                if (value.getName().equals(device.getName()) && value.getType().equals(device.getType())) {
                    flag = 0;
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
        if (flag == 1) {
            updateDevice(device);
            return deviceDao.save(device);
        }
        else return null;
    }

    @Override
    public void deleteDeviceById(Integer deviceId) {
        deviceDao.deleteById(deviceId);
    }

    @Override
    public Device updateDevice(Device device) {
//        String accessKeyId = aliIotConfigProperties.getAccessKeyId();
//        String accessKeySecret = aliIotConfigProperties.getAccessKeySecret();
//        String regionId = aliIotConfigProperties.getRegionId(); // 你的物联网平台服务的地域代码
//
//        // 创建DefaultProfile
//        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        PubRequest request = new PubRequest();
//        request.setIotInstanceId(aliIotConfigProperties.getIotInstanceId());
//        request.setQos(0);
//
//        request.setTopicFullName("/" + device.getProductKey() + "/" + device.getName() + "/user/cloudmsg");
//        request.setProductKey(device.getProductKey());
//
//        String content = "{\"parameters\":" + device.getParameters() + "}";
//        request.setMessageContent(Base64.encodeBase64String(content.getBytes()));
//
//        try {
//            // 发送消息
//            PubResponse response = client.getAcsResponse(request);
//            System.out.println("MessageId: " + response.getMessageId());
//            System.out.println("Code: " + response.getCode());
//            System.out.println("Success: " + response.getSuccess());
//        } catch (ClientException e) {
//            System.out.println("ErrCode:" + e.getErrCode());
//            System.out.println("ErrMsg:" + e.getErrMsg());
//            e.printStackTrace();
//        }
        if (device.getParameters() == null || device.getParameters().trim().isEmpty()) {
            throw new IllegalArgumentException("Parameters cannot be null or empty");
        }
        JSONObject jsonObject = new JSONObject(device.getParameters());

        if (device.getType().equals("Airconditionerthermostat")) {
            AcPrefer ap = new AcPrefer();
            ap.setUserId(device.getUserId());
            ap.setDeviceId(device.getId());
            ap.setParameters(device.getParameters());
            ap.setTemperature(String.valueOf(jsonObject.getJSONObject("TargetTemperature").getDouble("value")));
            Date date = new Date(System.currentTimeMillis());
            ap.setStartTime(date);
            acPreferServiceImpl.addRecord(ap);
        }
        else if (device.getType().equals("LightingFacility")) {
            LightPrefer lp = new LightPrefer();
            lp.setUserId(device.getUserId());
            lp.setDeviceId(device.getId());
            lp.setBrightness(String.valueOf(jsonObject.getJSONObject("brightness").getInt("value")));
            lp.setColor(String.valueOf(jsonObject.getJSONObject("lighttype").getInt("value")));
            Date date = new Date(System.currentTimeMillis());
            lp.setStartTime(date);
            lightPreferServiceImpl.addRecord(lp);
        }
        else if (device.getType().equals("CurrentTemperature")) {
            EnvironmentData ed = new EnvironmentData();
            ed.setDeviceId(device.getId());
            ed.setTemperature(jsonObject.getJSONObject("CurrentTemperature").getDouble("value"));
            ed.setHumidity(jsonObject.getJSONObject("CurrentHumidity").optDouble("value"));
            Date date = new Date(System.currentTimeMillis());
            ed.setCreateTime(date);
            environmentDataServiceImpl.addData(ed);
        }

        return deviceDao.save(device);
    }

    @Override
    public Device getDeviceById(Integer deviceId) {
        return deviceDao.findById(deviceId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常");
        });
    }

    @Override
    public List<Device> getDeviceList(Integer userId) {
        Iterable<Device> iterator = deviceDao.findAll();
        List<Device> deviceList=new ArrayList<>();
        for(Device device:iterator){
            deviceList.add(device);
        }
        return deviceList;
    }

    @Override
    public List<Device> getDeviceListByType(Integer userId,String type) {
        Iterable<Device> iterator = deviceDao.findAll();
        List<Device> deviceList=new ArrayList<>();
        for(Device device:iterator){
            if(device.getUserId() == null || device.getType() == null) continue;
            if(device.getType().equals(type) && device.getUserId().equals(userId)) deviceList.add(device);
        }
        return deviceList;
    }

    @Override
    public void deleteDeviceByIds(Integer[] deviceIds) {
        for(Integer deviceId: deviceIds) {
            deviceDao.deleteById(deviceId);
        }
    }

    @Override
    public List<Device> getDeviceListByDevice(String name,String type,String status,Integer userId) {
        Iterable<Device> iterator = deviceDao.findAll();
        List<Device> deviceList=new ArrayList<>();
        for(Device devices :iterator){
            if(name != null && name.equals(devices.getName()) ||
               userId != null && userId.equals(devices.getUserId()) ||
               type != null && type.equals(devices.getType()) ||
               status != null && status.equals(devices.getStatus()) ) deviceList.add(devices);
        }
        return deviceList;
    }
}
