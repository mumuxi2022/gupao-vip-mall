package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.dto.FlashPromotionProduct;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsBrandExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsBrandMapper {
    long countByExample(GoodsBrandExample example);

    int deleteByExample(GoodsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsBrand record);

    int insertSelective(GoodsBrand record);

    List<GoodsBrand> selectByExampleWithBLOBs(GoodsBrandExample example);

    List<GoodsBrand> selectByExample(GoodsBrandExample example);

    GoodsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByExample(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByPrimaryKeySelective(GoodsBrand record);

    int updateByPrimaryKeyWithBLOBs(GoodsBrand record);

    int updateByPrimaryKey(GoodsBrand record);

    /**
     * 获取推荐品牌
     */
    List<GoodsBrand> getRecommendBrandList(@Param("list") List<Long> list,@Param("offset") Integer offset,@Param("limit") Integer limit);

}