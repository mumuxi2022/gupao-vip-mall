package com.jt.feign;

import com.jt.model.UserMemberLevel;
import com.jt.model.UserMemberLevelExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-user")
public interface UserMemberLevelFeign {

    @PostMapping(value = "/memberLevel/countByExample")
    long countByExample(@RequestBody UserMemberLevelExample example);

    @PostMapping(value = "/memberLevel/deleteByExample")
    int deleteByExample(@RequestBody UserMemberLevelExample example);

    @DeleteMapping(value = "/memberLevel/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/memberLevel/insert")
    int insert(@RequestBody UserMemberLevel record);

    @PostMapping(value = "/memberLevel/insertSelective")
    int insertSelective(@RequestBody UserMemberLevel record);

    @PostMapping(value = "/memberLevel/selectByExample")
    List<UserMemberLevel> selectByExample(@RequestBody UserMemberLevelExample example);

    @GetMapping(value = "/memberLevel/selectByPrimaryKey")
    UserMemberLevel selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/memberLevel/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/memberLevel/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/memberLevel/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UserMemberLevel record);

    @PostMapping(value = "/memberLevel/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UserMemberLevel record);
}
