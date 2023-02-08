package com.phoenix.web;



import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author tianFeng
 * @date 2022-08-02 11:00
 */
public class TestMy {

    public static void date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 年-月-日
        String transformDate = simpleDateFormat.format(new Date());
        Date date= null;
        try {
            date = simpleDateFormat.parse(transformDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }


    public static void test(Map map) {

        //Map<String, String> map2 = new HashMap<String, String>();

        //map = map2;

        //map2.put("c", "3");

        map.put("c", "3");
    }

    public static void testMap2(Map<String, MyUser> map) {

        //Map<String, String> map2 = new HashMap<String, String>();

        //map = map2;

        MyUser myUser = new MyUser();
        myUser.setId(222L);
        myUser.setName("world");
        map.put("c", myUser);

    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().toLocalDate());

        System.out.println(isInteger("0"));
        System.out.println(isInteger("-09"));
        System.out.println(isInteger("123"));
        System.out.println(isInteger("+4"));

        System.out.println(Integer.valueOf("-09"));
        System.out.println(Integer.valueOf("+109"));




        Integer seq = 1;
        System.out.println(seq++);
        System.out.println(seq++);
        System.out.println(LocalDateTime.now().getYear());
        System.out.println(LocalDateTime.now().getMonthValue());
        System.out.println(LocalDateTime.now().getDayOfMonth());


        System.out.println(isNumeric("111"));
        System.out.println(isNumeric("111.22"));
        System.out.println(isNumeric(null));
        System.out.println(isNumeric(""));


        boolean numeric = StringUtils.isNumeric("1112");
        System.out.println(numeric);


        String phone = "183";
        String res = "";
        StringBuilder stringBuilder = new StringBuilder(phone);
        System.out.println(phone.length());
        if (StringUtils.isNotBlank(phone) && phone.length() >= 3) {
            res = stringBuilder.replace(3, 7, "****").toString();
        }
        System.out.println(res);

        boolean b = false;
        MyUser myUserxx = new MyUser();
        System.out.println(myUserxx.isB());
        

        String xxx = "111_ccc";
        String[] split = xxx.split("_");
        System.out.println(split[0]);
        System.out.println(split[1]);

        LocalDateTime payTime = LocalDateTime.of(2022, 8, 20, 0, 0, 0);
        LocalDateTime sixMonthBefore = LocalDateTime.now().plusMonths(-6);
        System.out.println(payTime.plusMonths(-6));

        Duration between = Duration.between(payTime, LocalDateTime.now());
        long betweenMinutes = between.toMinutes();
        long betweenHours = between.toHours();
        System.out.println(betweenMinutes);
        System.out.println(betweenHours);




        if (payTime.isBefore(sixMonthBefore)) {
            System.out.println("6月以前");
        } else {
            System.out.println("6月以后");
        }


        List<Integer> ll = Lists.newArrayList(80, 90);
        System.out.println(ll.contains(80));


        Integer iii = 11;
        System.out.println(Objects.equals("11", 11));
        System.out.println(Objects.equals(Integer.valueOf("11"), 11));
        System.out.println(Objects.equals("11", iii.toString()));



        Instant instant = Instant.ofEpochMilli(1636109854000L);
        LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("1636109854000L: " + time);


        LocalDateTime time1 = Instant.ofEpochMilli(new Date().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        System.out.println("current time: " + time1);


        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:" + now);
        System.out.println("hour:" + now.getHour());

        LocalDateTime of = LocalDateTime.of(2022, 8, 31, 23, 5, 12);
        System.out.println("of:" + of);
        System.out.println("hour:" + of.getHour());

        System.out.println("day+1:" + of.plusDays(1));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date());
        System.out.println("transformDate:" + format1);
        System.out.println("stamp:" + new Date().getTime());

        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("timestamp:" + timestamp);



        /*LocalDateTime of1 = LocalDateTime.of(of.getYear(), of.getMonth(), of.getDayOfMonth() + 1,
                22, 30, 0);
        System.out.println("of1:" + of1);*/



        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> hello_ = executorService.submit(() -> {
            System.out.println("hello ");
            Thread.sleep(5000);
            System.out.println("execute: " + Thread.currentThread());
            return 2;
        });
        System.out.println("main: " + Thread.currentThread());
        try {
            Integer integer = hello_.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main end ");



        Map<String, MyUser> map11 = new HashMap<String, MyUser>();
        MyUser myUser = new MyUser();
        myUser.setId(111L);
        myUser.setName("hello");
        map11.put("111", myUser);

        testMap2(map11);
        System.out.println(map11);


        Map<String,String> map = new HashMap<String,String>();

        map.put("a", "1");

        map.put("b", "2");

        test(map);

        System.out.println(map.get("a"));

        System.out.println(map.get("b"));

        System.out.println(map.get("c"));

        date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String transformDate=simpleDateFormat.format(new Date());
        System.out.println("日期转换前："+new Date());
        System.out.println("日期转换后："+transformDate);

        Map<String, List<Integer>> abMap = Maps.newHashMap();
        System.out.println(abMap.get("hello"));
        System.out.println(abMap);


        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Integer> collect = list.stream().filter(i -> i < 6).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));

        System.out.println(list);

        LocalDateTime ldt = LocalDateTime.now();
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(out);

        Map<String, String> map2 = Maps.newHashMap();
        testMap(map2);

        for (Map.Entry entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "------" + entry.getValue());

        }

    }

    public static void testMap(Map<String, String> map) {

        map.put("hello", "world");

    }
}
