package com.zb.service;


import com.zb.pojo.*;

import java.util.List;

public interface GoodService {
    /**
     * 查询所有商品
     * @return
     */
    List<Goodsku> listGood();

    /**
     * 查询所有条数
     * @return
     */
    int count();

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int updateLogic_status(Integer id);

    /**
     * 查询商品具体信息
     * @return
     */
    List<Goodsku> findAllGoodsku();

    /**
     * 根据商品名或分类查询
     *
     * @param skuName
     * @param sortName
     * @return
     */
    List<Goodsku> fingByskuNameorSortName(String skuName, String sortName);

    /**
     * 添加商品
     * @param g
     * @return
     */
    int insertGood(Goodsku g);

    /**
     * 修改商品
     * @param g
     * @return
     */
    int updateGood(Goodsku g);

    /**
     * 向spu添加数据
     * @param sp
     * @return
     */

    int insertGoodspu(Goodspu sp);

    /**
     * 添加供应商
     * @param v
     * @return
     */
    int insertvendor(Vendor v);

    /**
     * 添加价格
     * @param p
     * @return
     */
    int insertprice(Price p);

    /**
     * 添加库存
     * @param w
     * @return
     */
    int insertStock(Warehouse w);



    /**
     * 添加分类
     * @param s
     * @return
     */
    int insertSort(Sort s);


    /**
     *查找所属分类
     * @param sortName
     * @return
     */
    Sort findSort(String sortName);


    /**
     * 查找颜色ID
     * @param colorName
     * @return
     */
    Color findColor(String colorName);


    /**
     * 查找单位
     * @param unitsName
     * @return
     */
    Units findUnits(String unitsName);

    /**
     * 查找spu
     * @param id
     * @return
     */
    Goodspu findspu(Integer id);
    /**
     * 查找价格id
     * @param price
     * @return
     */
    int findPrice(double price);

    /**
     * 查找价格
     * @param price
     * @return
     */
    Price findPriceTwo(double price);

    /**
     * 查找库存
     * @param stockNumber
     * @return
     */
    Warehouse findWarehouse(Integer stockNumber);

    /**
     * 查找经销商
     * @param vendorName
     * @return
     */
    int findVendor(String vendorName);

    /**
     * 查找经销商
     * @param vendorName
     * @return
     */
    Vendor findVendorTwo(String vendorName);
    /**
     * 查找库存
     * @param stockNumber
     * @return
     */
    int findWarehouseTwo(Integer stockNumber);
    /**
     * 修改sku价格
     * @param g
     * @return
     */
    int updateGoodskuPrice(Goodsku g);

    /**
     * 修改单位
     * @param u
     * @return
     */
    int updateUnits(Units u);

    /**
     * 修改spu
     * @return
     */
    int updateSpu(Goodspu g);
    /**
     * 修改分类
     * @param s
     * @return
     */
    int updateSort(Sort s);

    /**
     * 修改价格
     * @param p
     * @return
     */
    int updatePrice(Price p);

    /**
     * 修改颜色
     * @param c
     * @return
     */
    int updateColor(Color c);

    /**
     * 修改库存
     * @param w
     * @return
     */
    int updateWarehouse(Warehouse w);
    /**
     * 修改经销商
     * @param v
     * @return
     */
    int updateVendor(Vendor v);
}
