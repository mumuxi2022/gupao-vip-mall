package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberStatisticsInfo;
import com.jt.model.UserMemberStatisticsInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberStatisticsInfoMapper {
    long countByExample(UserMemberStatisticsInfoExample example);

    int deleteByExample(UserMemberStatisticsInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberStatisticsInfo record);

    int insertSelective(UserMemberStatisticsInfo record);

    List<UserMemberStatisticsInfo> selectByExample(UserMemberStatisticsInfoExample example);

    UserMemberStatisticsInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberStatisticsInfo record, @Param("example") UserMemberStatisticsInfoExample example);

    int updateByExample(@Param("record") UserMemberStatisticsInfo record, @Param("example") UserMemberStatisticsInfoExample example);

    int updateByPrimaryKeySelective(UserMemberStatisticsInfo record);

    int updateByPrimaryKey(UserMemberStatisticsInfo record);
}