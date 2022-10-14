package com.jt.mallservicecanal.listener;

import com.jt.feign.EsControllerFeign;
import com.jt.model.GoodsProduct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;


@CanalTable(value = "goods_product")
@Component
public class GoodsProductHandler implements EntryHandler<GoodsProduct> {

    @Autowired
    private EsControllerFeign esControllerFeign;

    /***
     * 增加数据监听
     * @param goodsProduct
     */
    @SneakyThrows
    @Override
    public void insert(GoodsProduct goodsProduct) {
        esControllerFeign.create(goodsProduct.getId());
    }

    /****
     * 修改数据监听
     * @param before
     * @param after
     */
    @SneakyThrows
    @Override
    public void update(GoodsProduct before, GoodsProduct after) {
        esControllerFeign.create(after.getId());
    }

    /***
     * 删除数据监听
     * @param goodsProduct
     */
    @Override
    public void delete(GoodsProduct goodsProduct) {
        esControllerFeign.delete(goodsProduct.getId());
    }
}
