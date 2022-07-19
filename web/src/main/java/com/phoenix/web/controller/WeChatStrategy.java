package com.phoenix.web.controller;

import org.springframework.stereotype.Component;

/**
 * @author tianfeng
 * @date 2022-01-13 15:00
 */

@Component
@StrategyType(PayStrategyEnum.WECHAT_PAY)
public class WeChatStrategy implements PayStrategy {
    @Override
    public String pay(String method) {
        return "调用微信支付...WeChatPayStrategy";
    }
}
