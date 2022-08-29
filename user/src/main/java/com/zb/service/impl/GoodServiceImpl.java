package com.zb.service.impl;


import com.zb.mapper.GoodMapper;
import com.zb.pojo.*;
import com.zb.service.GoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {


    @Resource
    private GoodMapper goodMapper;


    /**
     * 查询商品
     * @return
     */
    @Override
    public List<Goodsku> listGood() {
        return goodMapper.listGood();
    }

    /**
     * 查询商品spu
     *
     * @return
     */
    @Override
    public List<Goodspu> listGoodSpu() {
        return goodMapper.listGoodSpu();
    }

    /**
     * 根据商品名或分类查询
     *
     *
     * @param skuName
     * @return
     */
    @Override
    public List<Goodsku> fingByskuNameorSortName(String skuName,String sortName) {
        return goodMapper.fingByskuNameorSortName(skuName,sortName);
    }

    /**
     * 查询商品具体信息
     *
     * @return
     */
    @Override
    public List<Goodsku> findAllGoodsku() {
        return goodMapper.findAllGoodsku();
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @Override
    public int updateLogic_status(Integer id) {
        return goodMapper.updateLogic_status(id);
    }

    /**
     * 查询所有条数
     *
     * @return
     */
    @Override
    public int count() {
        return goodMapper.count();
    }

    /**
     * 添加颜色
     *
     * @param c
     * @return
     */
    @Override
    public int insertColor(Color c) {
        return goodMapper.insertColor(c);
    }

    /**
     * 查询全部颜色
     *
     * @return
     */
    @Override
    public List<Color> listColor() {
        return goodMapper.listColor();
    }

    /**
     * 查询全部分类
     *
     * @return
     */
    @Override
    public List<Sort> listSort() {
        return goodMapper.listSort();
    }

    /**
     * 查询全部单位
     *
     * @return
     */
    @Override
    public List<Units> listUnits() {
        return goodMapper.listUnits();
    }

    /**
     * 向spu添加数据
     *
     * @param sp
     * @return
     */
    @Override
    public int insertGoodspu(Goodspu sp) {
        return goodMapper.insertGoodspu(sp);
    }

    /**
     * 查找商品spu名
     *
     * @param id
     * @return
     */
    @Override
    public Goodspu findGoodName(Long id) {
        return goodMapper.findGoodName(id);
    }


    /**
     * 修改颜色
     *
     * @param c
     * @return
     */
    @Override
    public int updateColor(Color c) {
        return goodMapper.updateColor(c);
    }





    /**
     * 查找价格
     *
     * @param price
     * @return
     */
    @Override
    public Price findPriceTwo(BigDecimal price) {
        return goodMapper.findPriceTwo(price);
    }

    /**
     * 查找价格id
     *
     * @param price
     * @return
     */
    @Override
    public int findPrice(BigDecimal price) {
        return goodMapper.findPrice(price);
    }


    /**
     * 修改单位
     *
     * @param u
     * @return
     */
    @Override
    public int updateUnits(Units u) {
        return goodMapper.updateUnits(u);
    }

    /**
     * 修改sku价格
     *
     * @param g
     * @return
     */
    @Override
    public int updateGoodskuPrice(Goodsku g) {
        return goodMapper.updateGoodskuPrice(g);
    }
    /**
     * 修改价格
     *
     * @param p
     * @return
     */
    @Override
    public int updatePrice(Price p) {
        return goodMapper.updatePrice(p);
    }

    /**
     * 修改分类
     *
     * @param s
     * @return
     */
    @Override
    public int updateSort(Sort s) {
        return goodMapper.updateSort(s);
    }

    /**
     * 查找spu
     *
     * @param id
     * @return
     */
    @Override
    public Goodspu findspu(Long id) {
        return goodMapper.findspu(id);
    }

    /**
     * 修改spu
     *
     * @return
     */
    @Override
    public int updateSpu(Goodspu g) {
        return goodMapper.updateSpu(g);
    }

    /**
     * 修改商品
     *
     * @param g
     * @return
     */
    @Override
    public int updateGood(Goodsku g) {
        return goodMapper.updateGood(g);
    }


    /**
     * 查找颜色ID
     *
     * @param colorName
     * @return
     */
    @Override
    public Color findColor(String colorName) {
        return goodMapper.findColor(colorName);
    }

    /**
     * 添加价格
     *
     * @param p
     * @return
     */
    @Override
    public int insertprice(Price p) {
        return goodMapper.insertprice(p);
    }

    /**
     * 查找所属分类
     *
     * @param sortName
     * @return
     */
    @Override
    public Sort findSort(String sortName) {
        return goodMapper.findSort(sortName);
    }

    /**
     * 添加单位
     *
     * @param u
     * @return
     */
    @Override
    public int insertUnits(Units u) {
        return goodMapper.insertUnits(u);
    }

    /**
     * 查找单位
     *
     * @param unitsName
     * @return
     */
    @Override
    public Units findUnitsTwo(String unitsName) {
        return goodMapper.findUnitsTwo(unitsName);
    }

    /**
     * 查找所属分类
     *
     * @param sortName
     * @return
     */
    @Override
    public Sort findSortTwo(String sortName) {
        return goodMapper.findSortTwo(sortName);
    }

    /**
     * 添加分类
     *
     * @param s
     * @return
     */
    @Override
    public int insertSort(Sort s) {
        return goodMapper.insertSort(s);
    }

    /**
     * 根据颜色查找
     *
     * @param colorName
     * @return
     */
    @Override
    public Color findColorTwo(String colorName) {
        return goodMapper.findColorTwo(colorName);
    }

    /**
     * 添加商品
     *
     * @param g
     * @return
     */
    @Override
    public int insertGood(Goodsku g) {
        return goodMapper.insertGood(g);
    }

    /**
     * 查找sku表信息用来跟添加作比较
     *
     * @return
     */
    @Override
    public List<Goodsku> listGoodskuMessage() {
        return goodMapper.listGoodskuMessage();
    }

    /**
     * 查找sku表
     *
     * @param skuName
     * @return
     */
    @Override
    public Goodsku listBySkuName(String skuName,Long colorId,Long priceId) {
        return goodMapper.listBySkuName(skuName,colorId,priceId);
    }

    /**
     * 查找sku表
     *
     * @param id
     * @return
     */
    @Override
    public Goodsku listByid(Long id) {
        return goodMapper.listByid(id);
    }

    /**
     * 查找spu表信息用来跟添加作比较
     *
     * @return
     */
    @Override
    public List<Goodspu> listGoodspu() {
        return goodMapper.listGoodspu();
    }


    /**
     * 查找单位
     *
     * @param unitsName
     * @return
     */
    @Override
    public Units findUnits(String unitsName) {
        return goodMapper.findUnits(unitsName);
    }
}
