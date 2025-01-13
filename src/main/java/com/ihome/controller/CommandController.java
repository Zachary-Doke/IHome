package com.ihome.controller;

import com.ihome.pojo.AcPrediction;
import com.ihome.pojo.Command;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/command")
public class CommandController {
    @Autowired
    private CommandService commandService;

    // 添加记录
    @PostMapping("/addRecord")
    public ResponseMessage<Command> addRecord(@RequestBody Command command) {
        Command result=commandService.addRecord(command);
        return ResponseMessage.success(result);
    }
}
