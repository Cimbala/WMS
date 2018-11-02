package com.ken.wms.common.util;

import java.util.regex.Pattern;

/**
 * Class: AppUtil
 * Description: v1.1
 * Author: Alan Min
 * Createtime: 2018/4/20
 */
public class AppUtil {

    private AppUtil(){}

    /*判断字符串是否不为空*/
    public static Boolean isNotNull(String s)
    {
        return ( (s!=null) && (!s.equals("")) );
    }

    /*判断字符串是否为空*/
    public static Boolean isNull(String s)
    {
        return ( (s==null) || (s.equals("")) );
    }

    /*判断字符串是否为数字*/
    public static Boolean isNumeric(String str) {
        Pattern pattern=Pattern.compile("\\d+(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }

    /*判断字符串是否为整数*/
    public static Boolean isIntNumeric(String str) {
        Pattern pattern=Pattern.compile("\\d+");
        return pattern.matcher(str).matches();
    }

    /*二进制数的字符串(16位)转为十六进制数的字符串(4位)*/
    public static String binStr2HexString(String binStr)
    {
        Integer temp=Integer.parseInt(binStr,2);
        return String.format("%04x", temp);
    }

}