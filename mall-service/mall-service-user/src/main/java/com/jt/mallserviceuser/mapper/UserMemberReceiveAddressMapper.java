package com.jt.mallserviceuser.mapper;

import java.util.List;

import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberReceiveAddressMapper {
    long countByExample(UserMemberReceiveAddressExample example);

    int deleteByExample(UserMemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserMemberReceiveAddress record);

    int insertSelective(UserMemberReceiveAddress record);

    List<UserMemberReceiveAddress> selectByExample(UserMemberReceiveAddressExample example);

    UserMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserMemberReceiveAddress record, @Param("example") UserMemberReceiveAddressExample example);

    int updateByExample(@Param("record") UserMemberReceiveAddress record, @Param("example") UserMemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(UserMemberReceiveAddress record);

    int updateByPrimaryKey(UserMemberReceiveAddress record);
}