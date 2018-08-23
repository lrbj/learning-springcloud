package com.imooc.order.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 3:49 PM 7/16/2018
 */

@Data
@Entity
public class OrderMaster {
    /**
     * 订单id.
     */
    @Id
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0未支付.
     */
    private Integer payStatus;

    /**
     * 创建时间.
     */
    @Transient
    private Date createTime;

    /**
     * 更新时间.
     */
    @Transient
    private Date updateTime;

}
