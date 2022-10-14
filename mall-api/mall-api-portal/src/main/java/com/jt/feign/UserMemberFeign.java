package com.jt.feign;

import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import com.jt.model.UserMember;
import com.jt.model.UserMemberExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 帅气的景天老师
 * @create 2022/9/27 15:09
 */
@FeignClient("mall-service-user")
public interface UserMemberFeign {

    @PostMapping(value = "/member/countByExample")
    long countByExample(@RequestBody UserMemberExample example);

    @PostMapping(value = "/member/deleteByExample")
    int deleteByExample(@RequestBody UserMemberExample example);

    @DeleteMapping(value = "/member/deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestParam("id") Long id);

    @PostMapping(value = "/member/insert")
    int insert(@RequestBody UserMember record);

    @PostMapping(value = "/member/insertSelective")
    int insertSelective(@RequestBody UserMember record);

    @PostMapping(value = "/member/selectByExample")
    List<UserMember> selectByExample(@RequestBody UserMemberExample example);

    @GetMapping(value = "/member/selectByPrimaryKey")
    UserMember selectByPrimaryKey(@RequestParam("id") Long id);

    @PutMapping(value = "/member/updateByExampleSelective")
    int updateByExampleSelective(@RequestParam("map") Map<String,Object> map);

    @PutMapping(value = "/member/updateByExample")
    int updateByExample(@RequestParam("map") Map<String,Object> map);

    @PostMapping(value = "/member/updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(@RequestBody UserMember record);

    @PostMapping(value = "/member/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody UserMember record);
}
