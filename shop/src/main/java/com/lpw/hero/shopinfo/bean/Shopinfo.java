package com.lpw.hero.shopinfo.bean;

import java.io.Serializable;

import org.springframework.format.annotation.NumberFormat;

import com.lpw.hero.utils.BaseBean;

/**
 * 商品信息
 * @author lpw
 *
 */
public class Shopinfo extends BaseBean implements Serializable{
	// 商品id
    private Integer shopId;
    // 商品名称
    private String shopName;
    // 商品价格
    private String price;
    // 商品图片
    private String shopImg;
    // 商品详情
    private String shopDetail;
    // 商品状态
    private String shopState;
    // 商品简介
    private String shopIntro;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg == null ? null : shopImg.trim();
    }

    public String getShopDetail() {
        return shopDetail;
    }

    public void setShopDetail(String shopDetail) {
        this.shopDetail = shopDetail == null ? null : shopDetail.trim();
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState == null ? null : shopState.trim();
    }

	public String getShopIntro() {
		return shopIntro;
	}

	public void setShopIntro(String shopIntro) {
		this.shopIntro = shopIntro;
	}

	@Override
	public String toString() {
		return "Shopinfo [shopId=" + shopId + ", shopName=" + shopName + ", price=" + price + ", shopImg=" + shopImg
				+ ", shopDetail=" + shopDetail + ", shopState=" + shopState + ", shopIntro=" + shopIntro + "]";
	}
    
}