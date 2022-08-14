    package com.zb.pojo;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.experimental.Accessors;

    import java.util.Date;

    /**
    * sku
    */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public class Goodsku {

    private Integer id;
    /** spu ID*/
    private Integer spuId;
    /** sku 名称*/
    private String skuName;
    /** 描述*/
    private String skuDesc;
    /** 颜色ID*/
    private Integer colorId;
    /** 价表ID*/
    private Integer priceId;
    /** 库存表ID*/
    private Integer stockId;
    /** 销量*/
    private Integer salesVolume;
    /** 单位ID*/
    private Integer companyId;
    /** 生产商*/
    private String manufacturer;
    /** 供应商ID*/
    private Integer supplierId;
      /**创建人id*/
    private Integer createUserId;
      /**创建时间*/
    private Date createTime;
      /**更新人id*/
    private Integer userRenewId;
      /**更新时间*/
    private Date renewTime;

    private Goodspu goodspu;
    private Sort sort;
    private User user;
    private Color color;
    private Price price;
    private Warehouse warehouse;
    private Units units;
    private Vendor vendor;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public Integer getSpuId() {
      return spuId;
    }

    public void setSpuId(Integer spuId) {
      this.spuId = spuId;
    }

    public String getSkuName() {
      return skuName;
    }

    public void setSkuName(String skuName) {
      this.skuName = skuName;
    }

    public String getSkuDesc() {
      return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
      this.skuDesc = skuDesc;
    }

    public Integer getColorId() {
      return colorId;
    }

    public void setColorId(Integer colorId) {
      this.colorId = colorId;
    }

    public Integer getPriceId() {
      return priceId;
    }

    public void setPriceId(Integer priceId) {
      this.priceId = priceId;
    }

    public Integer getStockId() {
      return stockId;
    }

    public void setStockId(Integer stockId) {
      this.stockId = stockId;
    }

    public Integer getSalesVolume() {
      return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
      this.salesVolume = salesVolume;
    }

    public Integer getCompanyId() {
      return companyId;
    }

    public void setCompanyId(Integer companyId) {
      this.companyId = companyId;
    }

    public String getManufacturer() {
      return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
    }

    public Integer getSupplierId() {
      return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
      this.supplierId = supplierId;
    }

    public Integer getCreateUserId() {
      return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
      this.createUserId = createUserId;
    }

    public Date getCreateTime() {
      return createTime;
    }

    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }

    public Integer getUserRenewId() {
      return userRenewId;
    }

    public void setUserRenewId(Integer userRenewId) {
      this.userRenewId = userRenewId;
    }

    public Date getRenewTime() {
      return renewTime;
    }

    public void setRenewTime(Date renewTime) {
      this.renewTime = renewTime;
    }

    public Goodspu getGoodspu() {
      return goodspu;
    }

    public void setGoodspu(Goodspu goodspu) {
      this.goodspu = goodspu;
    }

    public Sort getSort() {
      return sort;
    }

    public void setSort(Sort sort) {
      this.sort = sort;
    }

    public User getUser() {
      return user;
    }

    public void setUser(User user) {
      this.user = user;
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

    public Warehouse getWarehouse() {
      return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
      this.warehouse = warehouse;
    }

    public Units getUnits() {
      return units;
    }

    public void setUnits(Units units) {
      this.units = units;
    }

    public Vendor getVendor() {
      return vendor;
    }

    public void setVendor(Vendor vendor) {
      this.vendor = vendor;
    }
    }
