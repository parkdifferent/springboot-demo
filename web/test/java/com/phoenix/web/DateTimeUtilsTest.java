package com.phoenix.web;

import utils.DateTimeEnum;
import utils.DateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Auther: tianFeng
 * @Date: 2023-02-03 18:23
 */
public class DateTimeUtilsTest {
    public static void main(String[] args) {

        LocalDate localDate = DateTimeUtils.parseLocalDate("2023-02-04", DateTimeEnum.STANDARD_DATE);
        System.out.println(localDate);

        LocalDateTime localDateTime = DateTimeUtils.parseLocalDateTime("2023-02-04 18:25:00", DateTimeEnum.STANDARD_DATE_TIME);
        System.out.println(localDateTime);

        String formatStr = DateTimeUtils.format(LocalDateTime.now(), DateTimeEnum.STANDARD_DATE_TIME);
        System.out.println(formatStr);

    }

}
