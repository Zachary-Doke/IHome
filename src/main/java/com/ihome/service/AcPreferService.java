package com.ihome.service;

import com.ihome.pojo.AcPrefer;

import java.util.List;

public interface AcPreferService {
    /**
     * 添加一条记录
     * @param acPrefer
     * @return
     */
    AcPrefer addRecord(AcPrefer acPrefer);

    /**
     * 删除一条记录
     * @param recordId
     */
    void deleteRecord(Integer recordId);

    /**
     * 更新一条记录
     * @param acPrefer
     * @return
     */
    AcPrefer updateRecord(AcPrefer acPrefer);

    /**
     * 获取记录列表
     * @return
     */
    List<AcPrefer> getRecordList();
}
