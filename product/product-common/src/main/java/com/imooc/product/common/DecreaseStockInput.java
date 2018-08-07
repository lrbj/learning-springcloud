package com.imooc.product.common;

import lombok.Data;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:47 AM 8/6/2018
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
