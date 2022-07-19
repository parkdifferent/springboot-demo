package com.phoenix.web.controller;

/**
 * @author tianfeng
 * @date 2022-01-13 14:56
 */
public interface PayStrategy {

    /**
     * 付款方式
     * @param method
     * @return
     */
    String pay(String method);
}
