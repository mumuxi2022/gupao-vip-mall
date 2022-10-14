package com.jt.mallservicecontext.service.impl;

import com.jt.mallservicecontext.mapper.ContextPrefrenceAreaMapper;
import com.jt.mallservicecontext.service.ContextPrefrenceAreaService;
import com.jt.model.ContextPrefrenceArea;
import com.jt.model.ContextPrefrenceAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class ContextPrefrenceAreaServiceImpl implements ContextPrefrenceAreaService {
    @Autowired
    private ContextPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<ContextPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new ContextPrefrenceAreaExample());
    }
}
