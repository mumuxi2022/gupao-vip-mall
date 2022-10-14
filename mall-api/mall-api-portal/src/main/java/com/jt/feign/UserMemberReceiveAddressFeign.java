package com.jt.feign;

import com.jt.model.UserMemberReceiveAddress;
import com.jt.model.UserMemberReceiveAddressExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-user")
public interface UserMemberReceiveAddressFeign {

    @PostMapping(value = "/memberReceiveAddress/countByExample")
    long countByExample(@RequestBody UserMemberReceiveAddressExample example);

    @PostMapping(value = "/memberReceiveAddress/deleteByExample")
    int deleteByExample(@RequestBody UserMemberReceiveAddressExample example);

    @DeleteMapping(value = "/memberReceiveAddress/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/memberReceiveAddress/insert")
    int insert(@RequestBody UserMemberReceiveAddress record);

    @PostMapping(value = "/memberReceiveAddress/insertSelective")
    int insertSelective(@RequestBody UserMemberReceiveAddress record);

    @PostMapping(value = "/memberReceiveAddress/selectByExample")
    List<UserMemberReceiveAddress> selectByExample(@RequestBody UserMemberReceiveAddressExample example);

    @GetMapping(value = "/memberReceiveAddress/selectByPrimaryKey")
    UserMemberReceiveAddress selectByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/memberReceiveAddress/updateByExampleSelective")
    int updateByExampleSelective(@RequestBody Map<String,Object> map);

    @PostMapping(value = "/memberReceiveAddress/updateByExample")
    int updateByExample(@RequestBody Map<String,Object> map);

    @PostMapping(value = "/memberReceiveAddress/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UserMemberReceiveAddress record);

    @PostMapping(value = "/memberReceiveAddress/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UserMemberReceiveAddress record);
}
