package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
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
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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

        String orderId = KeyUtil.genUniqueKey ();
        //查询商品信息（调用接口查询）
        List<String> productIdList = orderDTO.getOrderDetailList ().stream ()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder ( productIdList );

        //计算总价
        BigDecimal orderAmout = new BigDecimal ( BigInteger.ZERO );
        for(OrderDetail orderDetail: orderDTO.getOrderDetailList ()){
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getProductId ().equals ( orderDetail.getProductId () )){
                    orderAmout = productInfo.getProductPrice ()
                            .multiply (new BigDecimal ( orderDetail.getProductQuantity () )  )
                            .add(orderAmout);
                    BeanUtils.copyProperties ( productInfo, orderDetail );
                    orderDetail.setOrderId ( orderId );
                    orderDetail.setDetailId ( KeyUtil.genUniqueKey () );

                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }

        }
        //扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList ().stream ()
                .map (e -> new CartDTO(e.getProductId (), e.getProductQuantity ()) )
                .collect(Collectors.toList());
        productClient.decreaseStock ( cartDTOList );

        //订单入库
        KeyUtil keyUtil = new KeyUtil ();
        OrderMaster orderMaster = new OrderMaster ();
        orderDTO.setOrderId ( orderId);
        BeanUtils.copyProperties ( orderDTO, orderMaster );

        orderMaster.setOrderAmount ( new BigDecimal ( 5 ) );
        orderMaster.setOrderStatus ( OrderStatusEnum.NEW.getCode () );
        orderMaster.setPayStatus ( PayStatusEnum.WAIT.getCode () );


        orderMasterRepository.save ( orderMaster );
        return  orderDTO;

    }
}
