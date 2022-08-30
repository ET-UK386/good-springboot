package com.zb.mapper;

import com.zb.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface GoodMapper {
    /**
     * 查询商品信息
     * @return
     */
    List<Goodsku> listGood();

    /**
     * 查询商品spu
      * @return
     */
    List<Goodspu> listGoodSpu();



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
     * @return
     */
    List<Goodsku> fingByskuNameorSortName(@Param("skuName") String skuName,@Param("sortName") String sortName);

    /**
     * 添加商品
     * @param g
     * @return
     */
    int insertGood(Goodsku g);

    /**
     * 添加颜色
     * @param c
     * @return
     */
    int insertColor(Color c);


    /**
     * 根据颜色查找
     * @param colorName
     * @return
     */
    Color findColorTwo(String colorName);
    /**
     * 向spu添加数据
     * @param sp
     * @return
     */
    int insertGoodspu(Goodspu sp);

    /**
     * 查找商品spu名
     * @param id
     * @return
     */
    Goodspu findGoodName(Long id);
    /**
     * 修改商品
     * @param g
     * @return
     */
    int updateGood(Goodsku g);

    /**
     * 添加价格
     * @param p
     * @return
     */
    int insertprice(Price p);





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
     *查找所属分类
     * @param sortName
     * @return
     */
    Sort findSortTwo(String sortName);
    /**
     * 查询全部分类
     * @return
     */
    List<Sort> listSort();

    /**
     * 查询全部单位
     * @return
     */
    List<Units> listUnits();

    /**
     * 查找sku表信息用来跟添加作比较
     * @return
     */
    List<Goodsku> listGoodskuMessage();

    /**
     * 查找spu表信息用来跟添加作比较
     * @return
     */
    List<Goodspu> listGoodspu();

    /**
     * 添加单位
     * @param u
     * @return
     */
    int insertUnits(Units u);

    /**
     * 查找sku表
     * @param id
     * @return
     */
    Goodsku listByid(Long id);

    /**
     * 查找sku表
     * @param skuName
     * @return
     */
    Goodsku listBySkuName(@Param("skuName") String skuName,@Param("colorId") Long colorId,@Param("priceId")Long priceId);
    /**
     * 查找spu
     * @param id
     * @return
     */
    Goodspu findspu(Long id);

    /**
     * 查找颜色ID
     * @param colorName
     * @return
     */
    Color findColor(String colorName);

    /**
     * 查询全部颜色
     * @return
     */
    List<Color> listColor();

    /**
     * 查找单位
     * @param unitsName
     * @return
     */
    Units findUnits(String unitsName);



    /**
     * 查找单位
     * @param unitsName
     * @return
     */
    Units findUnitsTwo(String unitsName);
    /**
     * 查找库存
     * @param stockNumber
     * @return
     */
    int findWarehouseTwo(Integer stockNumber);

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
     * 查找价格id
     * @param price
     * @return
     */
    int findPrice(BigDecimal price);

    /**
     * 查找价格
     * @param price
     * @return
     */
    Price findPriceTwo(BigDecimal price);
    /**
     * 修改spu
     * @return
     */
    int updateSpu(Goodspu g);

    /**
     * 修改sku价格
     * @param g
     * @return
     */
    int updateGoodskuPrice(Goodsku g);

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
     * 修改单位
     * @param u
     * @return
     */
    int updateUnits(Units u);
}
