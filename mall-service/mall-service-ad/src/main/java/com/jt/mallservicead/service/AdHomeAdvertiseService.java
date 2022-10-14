package com.jt.mallservicead.service;


import com.jt.model.AdHomeAdvertise;
import com.jt.model.AdHomeAdvertiseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页广告管理Service
 */
public interface AdHomeAdvertiseService {
    /**
     * 添加广告
     */
    int create(AdHomeAdvertise advertise);

    /**
     * 批量删除广告
     */
    int delete(List<Long> ids);

    /**
     * 修改上、下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     */
    AdHomeAdvertise getItem(Long id);

    /**
     * 更新广告
     */
    int update(Long id, AdHomeAdvertise advertise);

    /**
     * 分页查询广告
     */
    List<AdHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);

    long countByExample(AdHomeAdvertiseExample example);

    int deleteByExample(AdHomeAdvertiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdHomeAdvertise record);

    int insertSelective(AdHomeAdvertise record);

    List<AdHomeAdvertise> selectByExample(AdHomeAdvertiseExample example);

    AdHomeAdvertise selectByPrimaryKey(Long id);

    int updateByExampleSelective(AdHomeAdvertise record, AdHomeAdvertiseExample example);

    int updateByExample(AdHomeAdvertise record, AdHomeAdvertiseExample example);

    int updateByPrimaryKeySelective(AdHomeAdvertise record);

    int updateByPrimaryKey(AdHomeAdvertise record);
}
