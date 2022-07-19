package com.phoenix.web.controller;


/**
 * @author phoenix
 */

public enum PayStrategyEnum {

    /**
     * 阿里支付
     */
    ALI_PAY(1,"com.ultiwill.strategy.impl.AliPayStrategy"),
    /**
     * 微信支付
     */
    WECHAT_PAY(2,"com.ultiwill.strategy.impl.WeChatPayStrategy")

    ;

    private Integer type;

    private String desc;

    PayStrategyEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
