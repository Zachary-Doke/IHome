package com.ihome.service;


import com.ihome.pojo.EnvironmentData;

import java.util.List;

public interface EnvironmentDataService {
    /**
     * 添加数据
     * @param data
     * @return
     */
    EnvironmentData addData(EnvironmentData data);

    /**
     * 删除数据
     * @param dataId
     */
    void deleteData(Integer dataId);

    /**
     * 修改数据
     * @param data
     * @return
     */
    EnvironmentData updateData(EnvironmentData data);

    /**
     * 查询数据
     * @return
     */
    List<EnvironmentData> getEnvironmentDataList();
}
