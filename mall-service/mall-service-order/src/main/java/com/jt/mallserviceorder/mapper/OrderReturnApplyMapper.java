package com.jt.mallserviceorder.mapper;

import com.jt.dto.OrderReturnApplyQueryParam;
import com.jt.dto.OrderReturnApplyResult;
import com.jt.model.OrderReturnApply;
import com.jt.model.OrderReturnApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReturnApplyMapper {
    long countByExample(OrderReturnApplyExample example);

    int deleteByExample(OrderReturnApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnApply record);

    int insertSelective(OrderReturnApply record);

    List<OrderReturnApply> selectByExample(OrderReturnApplyExample example);

    OrderReturnApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);

    int updateByExample(@Param("record") OrderReturnApply record, @Param("example") OrderReturnApplyExample example);

    int updateByPrimaryKeySelective(OrderReturnApply record);

    int updateByPrimaryKey(OrderReturnApply record);

    /**
     * 查询申请列表
     */
    List<OrderReturnApply> getList(@Param("queryParam") OrderReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OrderReturnApplyResult getDetail(@Param("id")Long id);
}