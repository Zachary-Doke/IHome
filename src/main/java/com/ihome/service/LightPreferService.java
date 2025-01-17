package com.ihome.service;

import com.ihome.pojo.LightPrefer;

import java.util.List;

public interface LightPreferService {
    /**
     * 添加一条记录
     * @param lightPrefer
     * @return
     */
    LightPrefer addRecord(LightPrefer lightPrefer);

    /**
     * 删除一条记录
     * @param recordId
     */
    void deleteRecord(Integer recordId);

    /**
     * 更新一条记录
     * @param lightPrefer
     * @return
     */
    LightPrefer updateRecord(LightPrefer lightPrefer);

    /**
     * 获取记录列表
     * @return
     */
    List<LightPrefer> getRecordList(Integer deviceId);
}
