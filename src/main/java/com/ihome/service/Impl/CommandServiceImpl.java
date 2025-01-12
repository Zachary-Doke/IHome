package com.ihome.service.Impl;

import com.ihome.dao.CommandDao;
import com.ihome.pojo.Command;
import com.ihome.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {
    @Autowired
    private CommandDao commandDao;

    @Override
    public Command addRecord(Command command) {
        return commandDao.save(command);
    }
}
