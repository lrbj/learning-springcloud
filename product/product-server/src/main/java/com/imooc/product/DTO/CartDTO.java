package com.imooc.product.DTO;

import lombok.Data;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 2:43 PM 8/2/2018
 */
@Data
public class CartDTO {
    private  String producId;

    private  Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String producId,Integer productQuantity) {

        this.producId = producId;
        this.productQuantity = productQuantity;
    }
}
