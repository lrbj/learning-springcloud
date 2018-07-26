package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:14 PM 7/16/2018
 */
public class OrderDetailRepositoryTest  extends OrderApplicationTests {
    @Autowired
    OrderDetailRepository orderDetailRepository;


    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail ();
        orderDetail.setDetailId ( "1234567" );
        orderDetail.setOrderId ( "123456" );
        orderDetail.setProductId ( "http://xxx.com" );
        orderDetail.setProductId ( "123432344354656557567" );
        orderDetail.setProductName ( "皮蛋粥" );
        orderDetail.setProductPrice ( new BigDecimal ( 0.01 ) );
        orderDetail.setProductQuantity ( 2 );

        OrderDetail result = orderDetailRepository.save ( orderDetail );
        Assert.assertTrue (result != null);
    }

}