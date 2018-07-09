package com.lpw.hero.orderinfo.bean;

public class Orderinfo {
	// 订单id
    private Integer orderinfoId;
    // 商品id
    private Integer shopId;
    // 商品名称
    private String shopName;
    
    private Integer shopNum;

    private Double shopPrice;

    private Integer ordermId;
    
    private String orderShopimg;

    public Integer getOrderinfoId() {
        return orderinfoId;
    }

    public void setOrderinfoId(Integer orderinfoId) {
        this.orderinfoId = orderinfoId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public Integer getOrdermId() {
        return ordermId;
    }

    public void setOrdermId(Integer ordermId) {
        this.ordermId = ordermId;
    }

	public String getOrderShopimg() {
		return orderShopimg;
	}

	public void setOrderShopimg(String orderShopimg) {
		this.orderShopimg = orderShopimg;
	}
    
}