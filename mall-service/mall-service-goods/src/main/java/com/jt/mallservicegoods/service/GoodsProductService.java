package com.jt.mallservicegoods.service;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsProductParam;
import com.jt.dto.GoodsProductQueryParam;
import com.jt.dto.GoodsProductResult;
import com.jt.model.GoodsProduct;
import com.jt.model.GoodsProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理Service
 */
public interface GoodsProductService {
    /**
     * 创建商品
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(GoodsProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    GoodsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     */
    @Transactional
    int update(Long id, GoodsProductParam productParam);

    /**
     * 分页查询商品
     */
    List<GoodsProduct> list(GoodsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<GoodsProduct> list(String keyword);

    /**
     * 获取新品推荐
     */
    List<GoodsProduct> getNewProductList(Integer offset, Integer limit);
    /**
     * 获取人气推荐
     */
    List<GoodsProduct> getHotProductList(Integer offset,Integer limit);

    List<GoodsProduct> listByExample(GoodsProductExample goodsProductExample);

    List<GoodsProduct> listByIds(List<Long> ids);

    long countByExample(GoodsProductExample example);

    int deleteByExample(GoodsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProduct record);

    int insertSelective(GoodsProduct record);

    List<GoodsProduct> selectByExampleWithBLOBs(GoodsProductExample example);

    List<GoodsProduct> selectByExample(GoodsProductExample example);

    GoodsProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProduct record, GoodsProductExample example);

    int updateByExampleWithBLOBs(GoodsProduct record, GoodsProductExample example);

    int updateByExample(GoodsProduct record, GoodsProductExample example);

    int updateByPrimaryKeySelective(GoodsProduct record);

    int updateByPrimaryKeyWithBLOBs(GoodsProduct record);

    int updateByPrimaryKey(GoodsProduct record);
}
