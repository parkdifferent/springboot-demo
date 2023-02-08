package com.phoenix.web;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.roaringbitmap.RoaringBitmap;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author tianFeng
 * @date 2022-10-28 11:03
 */
public class Test1028 {

    public static void test(Integer a) {
        a++;
    }

    public static void test1(MyClass myClass) {
        Integer a = myClass.getA();

        myClass.setA(++a);
    }

    public static void main(String[] args) {

        String regex = "_";
        String[] split = "hello_world".split(regex);
        System.out.println(split[0]);
        System.out.println(split[1]);


        MyClass myClass = new MyClass();
        myClass.setA(0);
        Integer abc = 0;
        for (int i = 0; i < 10; i++) {
            test(abc);
            test1(myClass);
        }
        System.out.println("abc:"+ abc);
        System.out.println("myClass.a:" + myClass.getA());


        String str = "";
        System.out.println(str.length());
        System.out.println("2022-07-31".length());

        System.out.println(StringUtils.isNotBlank(str));
        System.out.println(StringUtils.isNotEmpty(str));
        System.out.println(StringUtils.isNotBlank(null));



        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse("2022-07-31", dateTimeFormatter);
        LocalDateTime ldt = LocalDateTime.of(ld, LocalTime.of(23, 59, 59));
        System.out.println(ldt);

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld2 = LocalDate.parse("20221104", dateTimeFormatter2);
        LocalDateTime ldt2 = LocalDateTime.of(ld2, LocalTime.of(23, 59, 59));
        System.out.println(ldt2);

        System.out.println("2022-07-31 compare 20221104:" + ldt.compareTo(ldt2));


        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = date.format(formatter);
        System.out.println(text);


        String hello_world = stringToMD5("hello world");
        System.out.println(hello_world);

        RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4255L);

        LocalDate localDate = LocalDate.of(2022, 11, 3);
        BigDecimal bigDecimal = new BigDecimal("1.11");
        BigDecimal bigDecimal2 = new BigDecimal("1.110");
        Integer i = 333;
        String hello = Joiner.on(";").skipNulls().join(localDate, "hello", i, null, "", bigDecimal);
        System.out.println(hello);

        String world = Joiner.on(";").skipNulls().join(localDate, "hello", 333L, null, "", bigDecimal2);
        System.out.println(world);

        LocalDate before = LocalDate.of(2022, 9, 1);
        LocalDate now = LocalDate.now();
        LocalDate param = before;
        while (param.isBefore(now)) {
            System.out.println(param);
            param = param.plusDays(1);
        }
    }

    /**
     * 使用springboot自带MD5加密
     * 需要引入包 import org.springframework.util.DigestUtils;
     * @param str
     * @return String
     */
    public static String stringToMD5(String str)
    {
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }
}
