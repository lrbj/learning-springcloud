package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:09 PM 7/16/2018
 */
public interface OrderDetailRepository extends JpaRepository <OrderDetail, String> {
    List <OrderDetail> findByOrderId(String orderId);
}
