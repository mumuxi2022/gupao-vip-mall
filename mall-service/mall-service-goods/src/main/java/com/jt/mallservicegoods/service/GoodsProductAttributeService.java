package com.jt.mallservicegoods.service;

import com.jt.dto.GoodsProductAttributeParam;
import com.jt.dto.ProductAttrInfo;
import com.jt.model.GoodsProductAttribute;
import com.jt.model.GoodsProductAttributeExample;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品属性Service
 */
public interface GoodsProductAttributeService {
    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 0->属性；2->参数
     */
    List<GoodsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 添加商品属性
     */
    @Transactional
    int create(GoodsProductAttributeParam goodsProductAttributeParam);

    /**
     * 修改商品属性
     */
    int update(Long id, GoodsProductAttributeParam productAttributeParam);

    /**
     * 获取单个商品属性信息
     */
    GoodsProductAttribute getItem(Long id);

    @Transactional
    int delete(List<Long> ids);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);

    long countByExample(GoodsProductAttributeExample example);

    int deleteByExample(GoodsProductAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductAttribute record);

    int insertSelective(GoodsProductAttribute record);

    List<GoodsProductAttribute> selectByExample(GoodsProductAttributeExample example);

    GoodsProductAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProductAttribute record, GoodsProductAttributeExample example);

    int updateByExample(GoodsProductAttribute record,GoodsProductAttributeExample example);

    int updateByPrimaryKeySelective(GoodsProductAttribute record);

    int updateByPrimaryKey(GoodsProductAttribute record);
}
