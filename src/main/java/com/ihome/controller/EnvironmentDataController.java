package com.ihome.controller;

import com.ihome.pojo.EnvironmentData;
import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.EnvironmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/environmentData")
public class EnvironmentDataController {
    @Autowired
    private EnvironmentDataService environmentDataService;

    //添加环境数据
    @PostMapping("/addEnvironmentData")
    public ResponseMessage<EnvironmentData> addData(EnvironmentData data){
        EnvironmentData result=environmentDataService.addData(data);
        return ResponseMessage.success(result);
    }

    //删除环境数据
    @DeleteMapping("/deleteEnvironmentData/{dataId}")
    public ResponseMessage<String> deleteData(@PathVariable Integer dataId) {
        environmentDataService.deleteData(dataId);
        return ResponseMessage.success("已执行删除操作");
    }

    //更新环境数据
    @PutMapping("/updateEnvironmentData")
    public ResponseMessage<EnvironmentData> updateData(@RequestBody EnvironmentData data) {
        EnvironmentData result=environmentDataService.updateData(data);
        return ResponseMessage.success(result);
    }

    //获取环境数据
    @GetMapping("/getEnvironmentData")
    public ResponseMessage<EnvironmentData> getEnvironmentData() {
        EnvironmentData data=new EnvironmentData();

        /*向设备发送查询环境数据请求并接收*/

        EnvironmentData result=environmentDataService.addData(data);
        return ResponseMessage.success(result);
    }

    //获取环境数据列表
    @GetMapping("/getEnvironmentDataList")
    public ResponseMessage<List<EnvironmentData>> getEnvironmentDataList() {
        List<EnvironmentData> result=environmentDataService.getEnvironmentDataList();
        return ResponseMessage.success(result);
    }

}
