package com.zb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopCar {
    /**id*/
    private Integer id;
    /**购物车内商品id*/
    private Long skuId;
    /**关联的spu表中的id*/
    private Long spuId;
    /**购物车内商品数量*/
    private Long number;
    /**购物车内单种商品总价*/
    private BigDecimal totalPrice;
    /**仓库里的该商品总库存*/
    private Long warehouseId;
    /**逻辑删除状态*/
    private Long logicState;

    private Goodsku goodsku;
    private Goodspu goodspu;
    private Warehouse warehouse;
    private Color color;
    private Price price;
    private ImagesPath imagesPath;

    public Long getLogicState() {
        return logicState;
    }

    public void setLogicState(Long logicState) {
        this.logicState = logicState;
    }

    public ImagesPath getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(ImagesPath imagesPath) {
        this.imagesPath = imagesPath;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", spuId=" + spuId +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", warehouseId=" + warehouseId +
                ", goodsku=" + goodsku +
                ", goodspu=" + goodspu +
                ", warehouse=" + warehouse +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Goodsku getGoodsku() {
        return goodsku;
    }

    public void setGoodsku(Goodsku goodsku) {
        this.goodsku = goodsku;
    }

    public Goodspu getGoodspu() {
        return goodspu;
    }

    public void setGoodspu(Goodspu goodspu) {
        this.goodspu = goodspu;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
