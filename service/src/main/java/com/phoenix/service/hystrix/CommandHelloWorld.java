package com.phoenix.service.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author tianFeng
 * @version 1.0, 2018/07/30
 */

public class CommandHelloWorld extends HystrixCommand<String> {

    private String name;

    /*protected CommandHelloWorld(HystrixCommandGroupKey group) {
        super(group);
    }*/

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }



    @Override
    protected String run() throws Exception {
        return "hello " + name;
    }
}
