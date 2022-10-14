package com.jt.mallservicegoods.service;

import com.jt.dto.GoodsProductCategoryParam;
import com.jt.dto.GoodsProductCategoryWithChildrenItem;
import com.jt.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类Service
 */
public interface GoodsProductCategoryService {
    /**
     * 创建商品分类
     */
    @Transactional
    int create(GoodsProductCategoryParam goodsProductCategoryParam);

    /**
     * 修改商品分类
     */
    @Transactional
    int update(Long id, GoodsProductCategoryParam goodsProductCategoryParam);

    /**
     * 分页获取商品分类
     */
    List<GoodsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 根据ID获取商品分类
     */
    GoodsProductCategory getItem(Long id);

    /**
     * 批量修改导航状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 以层级形式获取商品分类
     */
    List<GoodsProductCategoryWithChildrenItem> listWithChildren();

    List<GoodsProductCategory> listByExample(GoodsProductCategoryExample goodsProductCategoryExample);

    long countByExample(GoodsProductCategoryExample example);

    int deleteByExample(GoodsProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsProductCategory record);

    int insertSelective(GoodsProductCategory record);

    List<GoodsProductCategory> selectByExample(GoodsProductCategoryExample example);

    GoodsProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(GoodsProductCategory record, GoodsProductCategoryExample example);

    int updateByExample(GoodsProductCategory record,GoodsProductCategoryExample example);

    int updateByPrimaryKeySelective(GoodsProductCategory record);

    int updateByPrimaryKey(GoodsProductCategory record);
}
