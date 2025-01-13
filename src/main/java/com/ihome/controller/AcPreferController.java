package com.ihome.controller;

import com.ihome.pojo.AcPrefer;
import com.ihome.pojo.LightPrefer;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.AcPreferService;
import com.ihome.service.LightPreferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/acPrefer")
public class AcPreferController {
    @Autowired
    private AcPreferService acPreferService;

    //添加记录
    @PostMapping("/addRecord")
    public ResponseMessage<AcPrefer> addRecord(@RequestBody AcPrefer acPrefer) {
        AcPrefer result=acPreferService.addRecord(acPrefer);
        return ResponseMessage.success(result);
    }

    //删除记录
    @DeleteMapping("/deleteRecord/{recordId}")
    public ResponseMessage<String> deleteRecord(@PathVariable Integer recordId) {
        acPreferService.deleteRecord(recordId);
        return ResponseMessage.success("已执行删除操作");
    }

    //更新记录
    @PutMapping("/updateRecord")
    public ResponseMessage<AcPrefer> updateRecord(@RequestBody AcPrefer acPrefer) {
        AcPrefer result=acPreferService.updateRecord(acPrefer);
        return ResponseMessage.success(result);
    }

    //获取记录
    @GetMapping("/getRecordList")
    public ResponseMessage<List<AcPrefer>> getRecordList() {
        List<AcPrefer> result=acPreferService.getRecordList();
        return ResponseMessage.success(result);
    }

}
