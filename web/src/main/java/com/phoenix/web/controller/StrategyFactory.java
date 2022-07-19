package com.phoenix.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @author tianfeng
 * @date 2022-01-13 15:07
 */

@Component
@Slf4j
public class StrategyFactory implements ApplicationContextAware {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = this.applicationContext;
    }

    public PayStrategy getPayStrategy(PayStrategyEnum payStrategyEnum) {

        //Map<String, PayStrategy> beansOfType = applicationContext.getBeansOfType(PayStrategy.class);

        //applicationContext.findAnnotationOnBean()

        // Getting annotated beans with names
        Map<String, Object> allBeansWithNames = applicationContext.getBeansWithAnnotation(StrategyType.class);
        //If you want the annotated data
        PayStrategy result = null;
        for (Map.Entry<String, Object> entry : allBeansWithNames.entrySet()) {
            String beanName = entry.getKey();
            Object bean = entry.getValue();
            StrategyType strategyType = applicationContext.findAnnotationOnBean(beanName, StrategyType.class);
            log.info("testDetails: {}", strategyType);
            PayStrategyEnum value = strategyType.value();
            if (Objects.equals(value, payStrategyEnum)) {
                result = (PayStrategy) bean;
                break;
            }
        }
        return result;
    }
}
