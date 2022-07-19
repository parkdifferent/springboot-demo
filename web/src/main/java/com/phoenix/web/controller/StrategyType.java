package com.phoenix.web.controller;


import java.lang.annotation.*;

/**
 * @author phoenix
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrategyType {

    PayStrategyEnum value();
}
