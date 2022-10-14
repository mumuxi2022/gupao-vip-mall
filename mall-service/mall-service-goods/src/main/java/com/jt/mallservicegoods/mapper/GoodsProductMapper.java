package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsProductResult;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsProductMapper {
    long countByExample(GoodsProductExample example);

    int deleteByExample(GoodsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProduct record);

    int insertSelective(GoodsProduct record);

    List<GoodsProduct> selectByExampleWithBLOBs(GoodsProductExample example);

    List<GoodsProduct> selectByExample(GoodsProductExample example);

    GoodsProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByExample(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByPrimaryKeySelective(GoodsProduct record);

    int updateByPrimaryKeyWithBLOBs(GoodsProduct record);

    int updateByPrimaryKey(GoodsProduct record);

    /**
     * 获取商品编辑信息
     */
    GoodsProductResult getUpdateInfo(@Param("id") Long id);

    /**
     * 获取新品推荐
     */
    List<GoodsProduct> getNewProductList(List<Long> ids,@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<GoodsProduct> getHotProductList(List<Long> ids,@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(List<Long> idList);

    List<GoodsProduct> listByIds(List<Long> idList);

}