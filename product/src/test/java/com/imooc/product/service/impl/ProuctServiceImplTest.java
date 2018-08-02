package com.imooc.product.service.impl;

import com.imooc.product.DTO.CartDTO;
import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.ProductService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:27 AM 7/16/2018
 */
@Component
public class ProuctServiceImplTest  extends ProductApplicationTests {

    @Autowired
    private ProductService productService;
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list  = productService.findUpAll ();
        Assert.assertTrue ( (( List ) list).size () > 0  );
    }

    @Test
    public void findList() {
        List<ProductInfo> list  = productService.findList (Arrays.asList ("157875196366160022","157875227953464068"));
        Assert.assertTrue ( (( List ) list).size () > 0  );
    }

    @Test
    public void decreaseStock() throws  Exception {

        CartDTO cartDTO = new CartDTO ( "164103465734242707", 2 );
        productService.decreaseStock ( Arrays.asList ( cartDTO ) );
    }
}