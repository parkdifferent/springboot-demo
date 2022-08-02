package com.phoenix.web;

import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tianFeng
 * @date 2022-08-02 11:00
 */
public class TestMy {

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Integer> collect = list.stream().filter(i -> i < 6).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));


    }
}
