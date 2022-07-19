package com.phoenix.web.controller;

import org.springframework.stereotype.Component;

/**
 * @author phoenix
 * @Auther: tianfeng
 * @Date: 2021-02-19 10:03
 */

@StrategyType(PayStrategyEnum.ALI_PAY)
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String pay(String method) {
        return "调用阿里支付...AliPayStrategy";
    }
}
