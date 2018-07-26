package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:11 AM 7/16/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn() throws Exception  {
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn ( Arrays.asList (11,12) );
        Assert.assertTrue ( (( List ) list).size ()>0 );
    }
}