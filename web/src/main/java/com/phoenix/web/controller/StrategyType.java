package com.phoenix.web.controller;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrategyType {

    StrategyEnum[] value();
}
