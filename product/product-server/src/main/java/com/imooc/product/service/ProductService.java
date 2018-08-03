package com.imooc.product.service;

import com.imooc.product.DTO.CartDTO;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:17 AM 7/16/2018
 */
public interface ProductService  {

    List<ProductInfo> findUpAll();
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 口库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
