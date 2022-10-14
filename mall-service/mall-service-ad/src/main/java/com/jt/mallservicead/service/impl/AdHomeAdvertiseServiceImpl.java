package com.jt.mallservicead.service.impl;

import com.github.pagehelper.PageHelper;
import com.jt.mallservicead.mapper.AdHomeAdvertiseMapper;
import com.jt.mallservicead.service.AdHomeAdvertiseService;
import com.jt.model.AdHomeAdvertise;
import com.jt.model.AdHomeAdvertiseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 首页广告管理Service实现类
 */
@Service
public class AdHomeAdvertiseServiceImpl implements AdHomeAdvertiseService {
    @Autowired
    private AdHomeAdvertiseMapper advertiseMapper;

    @Override
    public int create(AdHomeAdvertise advertise) {
        advertise.setClickCount(0);
        advertise.setOrderCount(0);
        return advertiseMapper.insert(advertise);
    }

    @Override
    public int delete(List<Long> ids) {
        AdHomeAdvertiseExample example = new AdHomeAdvertiseExample();
        example.createCriteria().andIdIn(ids);
        return advertiseMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        AdHomeAdvertise record = new AdHomeAdvertise();
        record.setId(id);
        record.setStatus(status);
        return advertiseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public AdHomeAdvertise getItem(Long id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, AdHomeAdvertise advertise) {
        advertise.setId(id);
        return advertiseMapper.updateByPrimaryKeySelective(advertise);
    }

    @Override
    public List<AdHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AdHomeAdvertiseExample example = new AdHomeAdvertiseExample();
        AdHomeAdvertiseExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (!StringUtils.isEmpty(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (start != null && end != null) {
                criteria.andEndTimeBetween(start, end);
            }
        }
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    @Override
    public long countByExample(AdHomeAdvertiseExample example){
        return advertiseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdHomeAdvertiseExample example){
        return advertiseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return advertiseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdHomeAdvertise record){
        return advertiseMapper.insert(record);
    }

    @Override
    public int insertSelective(AdHomeAdvertise record){
        return advertiseMapper.insertSelective(record);
    }

    @Override
    public List<AdHomeAdvertise> selectByExample(AdHomeAdvertiseExample example){
        return advertiseMapper.selectByExample(example);
    }

    @Override
    public AdHomeAdvertise selectByPrimaryKey(Long id){
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AdHomeAdvertise record,AdHomeAdvertiseExample example){
        return advertiseMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AdHomeAdvertise record,AdHomeAdvertiseExample example){
        return advertiseMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AdHomeAdvertise record){
        return advertiseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdHomeAdvertise record){
        return advertiseMapper.updateByPrimaryKey(record);
    }
}
