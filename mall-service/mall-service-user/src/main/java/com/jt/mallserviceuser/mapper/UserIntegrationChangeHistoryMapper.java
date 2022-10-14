package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserIntegrationChangeHistory;
import com.jt.model.UserIntegrationChangeHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIntegrationChangeHistoryMapper {
    long countByExample(UserIntegrationChangeHistoryExample example);

    int deleteByExample(UserIntegrationChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIntegrationChangeHistory record);

    int insertSelective(UserIntegrationChangeHistory record);

    List<UserIntegrationChangeHistory> selectByExample(UserIntegrationChangeHistoryExample example);

    UserIntegrationChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserIntegrationChangeHistory record, @Param("example") UserIntegrationChangeHistoryExample example);

    int updateByExample(@Param("record") UserIntegrationChangeHistory record, @Param("example") UserIntegrationChangeHistoryExample example);

    int updateByPrimaryKeySelective(UserIntegrationChangeHistory record);

    int updateByPrimaryKey(UserIntegrationChangeHistory record);
}