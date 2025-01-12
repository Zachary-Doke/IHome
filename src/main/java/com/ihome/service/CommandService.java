package com.ihome.service;

import com.ihome.pojo.Command;

public interface CommandService {
    /**
     * 添加一条命令记录
     * @param command
     * @return
     */
    Command addRecord(Command command);
}
