package com.jt.mallservicegoods.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.jt.dto.FlashPromotionProduct;
import com.jt.dto.GoodsProductParam;
import com.jt.dto.GoodsProductQueryParam;
import com.jt.dto.GoodsProductResult;
import com.jt.feign.*;
import com.jt.mallservicegoods.mapper.*;
import com.jt.mallservicegoods.service.GoodsProductService;
import com.jt.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品管理Service实现类
 */
@Service
public class GoodsProductServiceImpl implements GoodsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsProductServiceImpl.class);
    @Autowired
    private GoodsProductMapper productMapper;
    @Autowired
    private GoodsMemberPriceMapper memberPriceMapper;
    @Autowired
    private GoodsProductLadderMapper productLadderMapper;
    @Autowired
    private GoodsProductFullReductionMapper productFullReductionMapper;
    @Autowired
    private GoodsSkuStockMapper skuStockMapper;
    @Autowired
    private GoodsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private ContextSubjectProductRelationFeign contextSubjectProductRelationFeign;
    @Autowired
    private ContextPrefrenceAreaProductRelationFeign contextPrefrenceAreaProductRelationFeign;
    @Autowired
    private GoodsProductVertifyRecordMapper productVertifyRecordMapper;
    @Autowired
    private AdHomeRecommendProductFeign adHomeRecommendProductFeign;
    @Autowired
    private AdHomeNewProductFeign adHomeNewProductFeign;

    @Override
    public int create(GoodsProductParam productParam) {
        int count;
        //创建商品
        GoodsProduct product = productParam;
        product.setId(null);
        productMapper.insertSelective(product);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        relateAndInsertList(memberPriceMapper, productParam.getMemberPriceList(), productId);
        //阶梯价格
        relateAndInsertList(productLadderMapper, productParam.getProductLadderList(), productId);
        //满减价格
        relateAndInsertList(productFullReductionMapper, productParam.getProductFullReductionList(), productId);
        //处理sku的编码
        handleSkuStockCode(productParam.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(skuStockMapper, productParam.getSkuStockList(), productId);
        //添加商品参数,添加自定义商品规格
        relateAndInsertList(productAttributeValueMapper, productParam.getProductAttributeValueList(), productId);
        //关联专题
        relateAndInsertList(contextSubjectProductRelationFeign, productParam.getSubjectProductRelationList(), productId);
        //关联优选
        relateAndInsertList(contextPrefrenceAreaProductRelationFeign, productParam.getPrefrenceAreaProductRelationList(), productId);
        count = 1;
        return count;
    }

    private void handleSkuStockCode(List<GoodsSkuStock> skuStockList, Long productId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            GoodsSkuStock skuStock = skuStockList.get(i);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

    @Override
    public GoodsProductResult getUpdateInfo(Long id) {
        GoodsProductResult goodsProductResult = productMapper.getUpdateInfo(id);
        goodsProductResult.setPrefrenceAreaProductRelationList(
                contextPrefrenceAreaProductRelationFeign.
                        getListByProductId(goodsProductResult.getId()).getData());
        goodsProductResult.setSubjectProductRelationList(
                contextSubjectProductRelationFeign.
                        getListByProductId(goodsProductResult.getId()).getData());
        return goodsProductResult;
    }

    @Override
    public int update(Long id, GoodsProductParam productParam) {
        int count;
        //更新商品信息
        GoodsProduct product = productParam;
        product.setId(id);
        productMapper.updateByPrimaryKeySelective(product);
        //会员价格
        GoodsMemberPriceExample goodsMemberPriceExample = new GoodsMemberPriceExample();
        goodsMemberPriceExample.createCriteria().andProductIdEqualTo(id);
        memberPriceMapper.deleteByExample(goodsMemberPriceExample);
        relateAndInsertList(memberPriceMapper, productParam.getMemberPriceList(), id);
        //阶梯价格
        GoodsProductLadderExample ladderExample = new GoodsProductLadderExample();
        ladderExample.createCriteria().andProductIdEqualTo(id);
        productLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(productLadderMapper, productParam.getProductLadderList(), id);
        //满减价格
        GoodsProductFullReductionExample fullReductionExample = new GoodsProductFullReductionExample();
        fullReductionExample.createCriteria().andProductIdEqualTo(id);
        productFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(productFullReductionMapper, productParam.getProductFullReductionList(), id);
        //修改sku库存信息
        handleUpdateSkuStockList(id, productParam);
        //修改商品参数,添加自定义商品规格
        GoodsProductAttributeValueExample productAttributeValueExample = new GoodsProductAttributeValueExample();
        productAttributeValueExample.createCriteria().andProductIdEqualTo(id);
        productAttributeValueMapper.deleteByExample(productAttributeValueExample);
        relateAndInsertList(productAttributeValueMapper, productParam.getProductAttributeValueList(), id);
        //关联专题
        ContextSubjectProductRelationExample subjectProductRelationExample = new ContextSubjectProductRelationExample();
        subjectProductRelationExample.createCriteria().andProductIdEqualTo(id);
        contextSubjectProductRelationFeign.deleteByExample(subjectProductRelationExample);
        relateAndInsertList(contextSubjectProductRelationFeign, productParam.getSubjectProductRelationList(), id);
        //关联优选
        ContextPrefrenceAreaProductRelationExample prefrenceAreaExample = new ContextPrefrenceAreaProductRelationExample();
        prefrenceAreaExample.createCriteria().andProductIdEqualTo(id);
        contextPrefrenceAreaProductRelationFeign.deleteByExample(prefrenceAreaExample);
        relateAndInsertList(contextPrefrenceAreaProductRelationFeign, productParam.getPrefrenceAreaProductRelationList(), id);
        count = 1;
        return count;
    }

    private void handleUpdateSkuStockList(Long id, GoodsProductParam productParam) {
        //当前的sku信息
        List<GoodsSkuStock> currSkuList = productParam.getSkuStockList();
        //当前没有sku直接删除
        if(CollUtil.isEmpty(currSkuList)){
            GoodsSkuStockExample skuStockExample = new GoodsSkuStockExample();
            skuStockExample.createCriteria().andProductIdEqualTo(id);
            skuStockMapper.deleteByExample(skuStockExample);
            return;
        }
        //获取初始sku信息
        GoodsSkuStockExample skuStockExample = new GoodsSkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo(id);
        List<GoodsSkuStock> oriStuList = skuStockMapper.selectByExample(skuStockExample);
        //获取新增sku信息
        List<GoodsSkuStock> insertSkuList = currSkuList.stream().filter(item->item.getId()==null).collect(Collectors.toList());
        //获取需要更新的sku信息
        List<GoodsSkuStock> updateSkuList = currSkuList.stream().filter(item->item.getId()!=null).collect(Collectors.toList());
        List<Long> updateSkuIds = updateSkuList.stream().map(GoodsSkuStock::getId).collect(Collectors.toList());
        //获取需要删除的sku信息
        List<GoodsSkuStock> removeSkuList = oriStuList.stream().filter(item-> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
        handleSkuStockCode(insertSkuList,id);
        handleSkuStockCode(updateSkuList,id);
        //新增sku
        if(CollUtil.isNotEmpty(insertSkuList)){
            relateAndInsertList(skuStockMapper, insertSkuList, id);
        }
        //删除sku
        if(CollUtil.isNotEmpty(removeSkuList)){
            List<Long> removeSkuIds = removeSkuList.stream().map(GoodsSkuStock::getId).collect(Collectors.toList());
            GoodsSkuStockExample removeExample = new GoodsSkuStockExample();
            removeExample.createCriteria().andIdIn(removeSkuIds);
            skuStockMapper.deleteByExample(removeExample);
        }
        //修改sku
        if(CollUtil.isNotEmpty(updateSkuList)){
            for (GoodsSkuStock goodsSkuStock : updateSkuList) {
                skuStockMapper.updateByPrimaryKeySelective(goodsSkuStock);
            }
        }

    }

    @Override
    public List<GoodsProduct> list(GoodsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsProductExample productExample = new GoodsProductExample();
        GoodsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (productQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(productQueryParam.getPublishStatus());
        }
        if (productQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(productQueryParam.getProductSn());
        }
        if (productQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
        }
        if (productQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(productExample);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        GoodsProduct product = new GoodsProduct();
        product.setVerifyStatus(verifyStatus);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andIdIn(ids);
        List<GoodsProductVertifyRecord> list = new ArrayList<>();
        int count = productMapper.updateByExampleSelective(product, example);
        //修改完审核状态后插入审核记录
        for (Long id : ids) {
            GoodsProductVertifyRecord record = new GoodsProductVertifyRecord();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setDetail(detail);
            record.setStatus(verifyStatus);
            record.setVertifyMan("test");
            list.add(record);
        }
        productVertifyRecordMapper.insertList(list);
        return count;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        GoodsProduct record = new GoodsProduct();
        record.setPublishStatus(publishStatus);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        GoodsProduct record = new GoodsProduct();
        record.setRecommandStatus(recommendStatus);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        GoodsProduct record = new GoodsProduct();
        record.setNewStatus(newStatus);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        GoodsProduct record = new GoodsProduct();
        record.setDeleteStatus(deleteStatus);
        GoodsProductExample example = new GoodsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<GoodsProduct> list(String keyword) {
        GoodsProductExample productExample = new GoodsProductExample();
        GoodsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if(!StringUtils.isEmpty(keyword)){
            criteria.andNameLike("%" + keyword + "%");
            productExample.or().andDeleteStatusEqualTo(0).andProductSnLike("%" + keyword + "%");
        }
        return productMapper.selectByExample(productExample);
    }

    /**
     * 建立和插入关系表操作
     *
     * @param dao       可以操作的dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            LOGGER.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 获取新品推荐
     */
    @Override
    public List<GoodsProduct> getNewProductList(Integer offset, Integer limit){
        List<Long> ids = adHomeNewProductFeign.listAllProductId();
        return productMapper.getNewProductList(ids,offset,limit);
    }
    /**
     * 获取人气推荐
     */
    @Override
    public List<GoodsProduct> getHotProductList(Integer offset,Integer limit){
        List<Long> ids = adHomeRecommendProductFeign.listAllProductId();
        return productMapper.getHotProductList(ids,offset,limit);
    }

    @Override
    public List<GoodsProduct> listByExample(GoodsProductExample goodsProductExample){
        return productMapper.selectByExample(goodsProductExample);
    }

    @Override
    public List<GoodsProduct> listByIds(List<Long> ids){
        return productMapper.listByIds(ids);
    }

    @Override
    public long countByExample(GoodsProductExample example) {
        return productMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GoodsProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsProduct record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsProduct record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public List<GoodsProduct> selectByExampleWithBLOBs(GoodsProductExample example) {
        return productMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<GoodsProduct> selectByExample(GoodsProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public GoodsProduct selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(GoodsProduct record, GoodsProductExample example) {
        return productMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExampleWithBLOBs(GoodsProduct record, GoodsProductExample example) {
        return productMapper.updateByExampleWithBLOBs(record,example);
    }

    @Override
    public int updateByExample(GoodsProduct record, GoodsProductExample example) {
        return productMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsProduct record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(GoodsProduct record) {
        return productMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsProduct record) {
        return productMapper.updateByPrimaryKey(record);
    }
}
