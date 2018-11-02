package com.ken.wms;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Class: CommonTest
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/31
 */
public class CommonTest {

    @Test
    public void ct0()
    {
        String s="asd123";
        String pattern="\\d+";
        boolean isMatch= Pattern.matches(pattern,s);
        System.out.println("是否匹配："+isMatch);
    }

}
