package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:20 AM 7/19/2018
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //查询商品信息（调调）

       KeyUtil keyUtil = new KeyUtil ();
        OrderMaster orderMaster = new OrderMaster ();
        orderDTO.setOrderId ( keyUtil.genUniqueKey () );
        BeanUtils.copyProperties ( orderDTO, orderMaster );

        orderMaster.setOrderAmount ( new BigDecimal ( 5 ) );
        orderMaster.setOrderStatus ( OrderStatusEnum.NEW.getCode () );
        orderMaster.setPayStatus ( PayStatusEnum.WAIT.getCode () );


        orderMasterRepository.save ( orderMaster );
        return  orderDTO;

    }
}
