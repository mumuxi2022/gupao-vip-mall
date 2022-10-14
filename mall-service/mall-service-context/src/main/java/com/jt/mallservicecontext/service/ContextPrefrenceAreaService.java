package com.jt.mallservicecontext.service;


import com.jt.model.ContextPrefrenceArea;

import java.util.List;

/**
 * 优选专区Service
 */
public interface ContextPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<ContextPrefrenceArea> listAll();
}
