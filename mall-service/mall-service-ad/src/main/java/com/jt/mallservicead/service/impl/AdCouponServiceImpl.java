package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.dto.AdCouponParam;
import com.jt.mallservicead.mapper.AdCouponMapper;
import com.jt.mallservicead.mapper.AdCouponProductCategoryRelationMapper;
import com.jt.mallservicead.mapper.AdCouponProductRelationMapper;
import com.jt.mallservicead.service.AdCouponService;
import com.jt.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 优惠券管理Service实现类
 */
@Service
public class AdCouponServiceImpl implements AdCouponService {
    @Autowired
    private AdCouponMapper couponMapper;
    @Autowired
    private AdCouponProductRelationMapper productRelationMapper;
    @Autowired
    private AdCouponProductCategoryRelationMapper productCategoryRelationMapper;
    @Override
    public int create(AdCouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠券表
        int count = couponMapper.insert(couponParam);
        //插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(AdCouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            productRelationMapper.insertList(couponParam.getProductRelationList());
        }
        //插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (AdCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            productCategoryRelationMapper.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        //删除优惠券
        int count = couponMapper.deleteByPrimaryKey(id);
        //删除商品关联
        deleteProductRelation(id);
        //删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    private void deleteProductCategoryRelation(Long id) {
        AdCouponProductCategoryRelationExample productCategoryRelationExample = new AdCouponProductCategoryRelationExample();
        productCategoryRelationExample.createCriteria().andCouponIdEqualTo(id);
        productCategoryRelationMapper.deleteByExample(productCategoryRelationExample);
    }

    private void deleteProductRelation(Long id) {
        AdCouponProductRelationExample productRelationExample = new AdCouponProductRelationExample();
        productRelationExample.createCriteria().andCouponIdEqualTo(id);
        productRelationMapper.deleteByExample(productRelationExample);
    }

    @Override
    public int update(Long id, AdCouponParam couponParam) {
        couponParam.setId(id);
        int count =couponMapper.updateByPrimaryKey(couponParam);
        //删除后插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(AdCouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            productRelationMapper.insertList(couponParam.getProductRelationList());
        }
        //删除后插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (AdCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            productCategoryRelationMapper.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public List<AdCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        AdCouponExample example = new AdCouponExample();
        AdCouponExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if(type!=null){
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public AdCouponParam getItem(Long id) {
        return couponMapper.getItem(id);
    }

    @Override
    public List<AdCoupon> getAvailableCouponList(Long productId, Long productCategoryId){
        return couponMapper.getAvailableCouponList(productId,productCategoryId);
    }

    @Override
    public long countByExample(AdCouponExample example) {
        return couponMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdCouponExample example) {
        return couponMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdCoupon record) {
        return couponMapper.insert(record);
    }

    @Override
    public int insertSelective(AdCoupon record) {
        return couponMapper.insertSelective(record);
    }

    @Override
    public List<AdCoupon> selectByExample(AdCouponExample example) {
        return couponMapper.selectByExample(example);
    }

    @Override
    public AdCoupon selectByPrimaryKey(Long id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdCoupon record, AdCouponExample example) {
        return couponMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AdCoupon record, AdCouponExample example) {
        return couponMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdCoupon record) {
        return couponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdCoupon record) {
        return couponMapper.updateByPrimaryKey(record);
    }

}
