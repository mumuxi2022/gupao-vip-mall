package com.jt.mallservicegoods.service;

import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsBrandParam;
import com.jt.model.GoodsBrand;
import com.jt.model.GoodsBrandExample;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品品牌Service
 */
public interface GoodsBrandService {
    /**
     * 获取所有品牌
     */
    List<GoodsBrand> listAllBrand();

    /**
     * 创建品牌
     */
    int createBrand(GoodsBrandParam goodsBrandParam);

    /**
     * 修改品牌
     */
    @Transactional
    int updateBrand(Long id, GoodsBrandParam goodsBrandParam);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 批量删除品牌
     */
    int deleteBrand(List<Long> ids);

    /**
     * 分页查询品牌
     */
    List<GoodsBrand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * 获取品牌
     */
    GoodsBrand getBrand(Long id);

    /**
     * 修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 修改厂家制造商状态
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);

    /**
     * 获取推荐品牌
     */
    List<GoodsBrand> getRecommendBrandList(Integer offset, Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(Long flashPromotionId, Long sessionId);

    long countByExample(GoodsBrandExample example);

    int deleteByExample(GoodsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsBrand record);

    int insertSelective(GoodsBrand record);

    List<GoodsBrand> selectByExample(GoodsBrandExample example);

    GoodsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsBrand record, GoodsBrandExample example);

    int updateByExample(GoodsBrand record,GoodsBrandExample example);

    int updateByPrimaryKeySelective(GoodsBrand record);

    int updateByPrimaryKey(GoodsBrand record);
}
