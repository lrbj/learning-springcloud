package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 4:00 PM 7/16/2018
 */
public interface OrderMasterRepository extends JpaRepository <OrderMaster, String> {

}
