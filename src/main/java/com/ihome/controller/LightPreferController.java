package com.ihome.controller;

import com.ihome.pojo.LightPrefer;
import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.LightPreferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/lightPrefer")
public class LightPreferController {
    @Autowired
    private LightPreferService lightPreferService;

    //添加灯光记录
    @PostMapping("/addRecord")
    public ResponseMessage<LightPrefer> addRecord(@RequestBody LightPrefer lightPrefer) {
        LightPrefer result=lightPreferService.addRecord(lightPrefer);
        return ResponseMessage.success(result);
    }

    //删除灯光记录
    @DeleteMapping("/deleteRecord/{recordId}")
    public ResponseMessage<String> deleteRecord(@PathVariable Integer recordId) {
        lightPreferService.deleteRecord(recordId);
        return ResponseMessage.success("已执行删除操作");
    }

    //更新灯光记录
    @PutMapping("/updateRecord")
    public ResponseMessage<LightPrefer> updateRecord(@RequestBody LightPrefer lightPrefer) {
        LightPrefer result=lightPreferService.updateRecord(lightPrefer);
        return ResponseMessage.success(result);
    }

    //获取灯光记录
    @GetMapping("/getRecordList")
    public ResponseMessage<List<LightPrefer>> getRecordList() {
        List<LightPrefer> result=lightPreferService.getRecordList();
        return ResponseMessage.success(result);
    }

}
