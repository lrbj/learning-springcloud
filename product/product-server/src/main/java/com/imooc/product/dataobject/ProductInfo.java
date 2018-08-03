package com.imooc.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 1:37 PM 7/13/2018
 */
@Data
//@Table(name="productinfo")
@Entity
public class ProductInfo {

    @Id
    private  String productId;

    /**名字.*/
    private String  productName;

    /** 单价.*/
    private BigDecimal  productPrice;

    /**库存.*/
    private  Integer productStock;

    /** 描述.*/
    private  String  productDescription;

    /** 小图.*/
    private String productIcon;

    /**状态， 0正常 1下架.*/
    private Integer productStatus;

    /**类目编号.*/
    private Integer categoryType;

    private Date createTime;

    private  Date updateTime;
}
