package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:14 PM 7/16/2018
 */
@Component
public class OrderMasterRepositoryTest  extends OrderApplicationTests {

    @Autowired
    private  OrderMasterRepository orderMasterRepository;

    @Test
    public  void testSave(){
        OrderMaster orderMaster = new OrderMaster ();
        orderMaster.setOrderId ( "1234567" );
        orderMaster.setBuyerName ( "kayla" );
        orderMaster.setBuyerPhone ("15005925637");
        orderMaster.setBuyerAddress ("慕课网");
        orderMaster.setBuyerOpenid ("11011110" );
        orderMaster.setOrderAmount ( new BigDecimal ( 2.5 ) );
        orderMaster.setOrderStatus ( OrderStatusEnum.NEW.getCode () );
        orderMaster.setPayStatus ( PayStatusEnum.WAIT.getCode () );

        Date time=new Date();
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderMaster.setCreateTime (time);
        orderMaster.setUpdateTime ( time );
        OrderMaster result = orderMasterRepository.save ( orderMaster );
        Assert.assertTrue ( result != null  );

    }

}