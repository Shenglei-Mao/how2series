package com.shenglei;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class TestHutool {
    public static void main(String[] args) {
        String dateStr = "2012-12-12 121:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
