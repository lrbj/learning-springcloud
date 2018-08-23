package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:15 AM 7/19/2018
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     *
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);

}
