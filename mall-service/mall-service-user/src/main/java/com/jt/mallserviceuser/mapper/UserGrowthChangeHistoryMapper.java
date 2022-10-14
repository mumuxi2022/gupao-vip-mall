package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserGrowthChangeHistory;
import com.jt.model.UserGrowthChangeHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGrowthChangeHistoryMapper {
    long countByExample(UserGrowthChangeHistoryExample example);

    int deleteByExample(UserGrowthChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserGrowthChangeHistory record);

    int insertSelective(UserGrowthChangeHistory record);

    List<UserGrowthChangeHistory> selectByExample(UserGrowthChangeHistoryExample example);

    UserGrowthChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserGrowthChangeHistory record, @Param("example") UserGrowthChangeHistoryExample example);

    int updateByExample(@Param("record") UserGrowthChangeHistory record, @Param("example") UserGrowthChangeHistoryExample example);

    int updateByPrimaryKeySelective(UserGrowthChangeHistory record);

    int updateByPrimaryKey(UserGrowthChangeHistory record);
}