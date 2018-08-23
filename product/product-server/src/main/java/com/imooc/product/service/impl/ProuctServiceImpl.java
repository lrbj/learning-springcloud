package com.imooc.product.service.impl;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:19 AM 7/16/2018
 */
@Service
public class ProuctServiceImpl implements ProductService {


    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus ( ProductStatusEnum.UP.getCode () );
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {

        return productInfoRepository.findByProductIdIn ( productIdList );
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

       List<ProductInfo>  productInfoList = decreaseStockProcess(decreaseStockInputList);

        //发送MQ 消息
      List<ProductInfoOutput> productInfoOutputList =   productInfoList.stream ().map (e ->{
            ProductInfoOutput output = new ProductInfoOutput ();
            BeanUtils.copyProperties (e, output);
            return  output;
                }).collect(Collectors.toList());

        amqpTemplate.convertAndSend ("productInfo",JsonUtil.toJson (productInfoOutputList));
    }

    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo>  productInfoList = new ArrayList <> ();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById ( decreaseStockInput.getProductId () );
            //判断商品是否存在
            if (!productInfoOptional.isPresent ()) {
                throw new ProductException ( ResultEnum.PRODUCT_NOT_EXIST );
            }

            ProductInfo productInfo = productInfoOptional.get ();
            //判断库存是否存在
            Integer result = productInfo.getProductStock () - decreaseStockInput.getProductQuantity ();
            if (result < 0) {
                throw new ProductException ( ResultEnum.PRODUCT_STOCK_ERROR );
            }

            productInfo.setProductStock ( result );
            productInfoRepository.save ( productInfo );

            productInfoList.add (productInfo);
        }

        return  productInfoList;
    }
}
