package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import  lombok.Data;
/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:57 AM 7/16/2018
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal  productPrice;

    @JsonProperty("description")
    private  String  productDescription;

    @JsonProperty("icon")
    private  String productIcon;


}
