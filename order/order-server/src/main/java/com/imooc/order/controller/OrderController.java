package com.imooc.order.controller;

import com.imooc.order.VO.ResultVO;
import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtil;
import io.swagger.annotations.ApiImplicitParam;
import javafx.print.Collation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 10:13 AM 7/19/2018
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 1、参数检验
     * 2、查询商品信息
     * 3、计算总价
     * 4、扣库存
     * 5、订单入库
     */
    @PostMapping("/create")
    @ApiImplicitParam(name = "orderForm", value = "订单信息", required = true, dataType = "OrderForm")
    public ResultVO <Map <String, String>> create(@Valid @RequestBody OrderForm orderForm,BindingResult bindingResult) {

        if (bindingResult.hasErrors ()) {
            log.error ("创建订单，参数不正确， orerForm = {}",orderForm);
            throw new OrderException (ResultEnum.PARAM_ERROR.getCode (),bindingResult.getFieldError ().getDefaultMessage ());
        }
        //OrderFrom ——》 OrdeDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert (orderForm);
        if (CollectionUtils.isEmpty (orderDTO.getOrderDetailList ())) {
            log.error ("[创建订单]购物车信息为空");
            throw new OrderException (ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create (orderDTO);

        Map <String, String> map = new HashMap <> ();
        map.put ("orderId",result.getOrderId ());
        return ResultVOUtil.success (map);
    }

    /**
     * 完结订单
     *
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public ResultVO <OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtil.success (orderService.finish (orderId));
    }
}
