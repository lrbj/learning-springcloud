package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:53 PM 8/1/2018
 */
@FeignClient(name ="product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    /**
     * 获取商品列表 （订单服务）
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
     List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList    );
}
