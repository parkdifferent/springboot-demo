package com.phoenix.web;

/**
 * @Auther: tianFeng
 * @Date: 2023-02-10 11:27
 */
public class TestProxy {
    public static void main(String[] args) throws Exception {
        ProxyFactory proxyFactory = new ProxyFactory(Demo.class);
        Demo demo = (Demo) proxyFactory.getProxyInstance();
        demo.hello();
    }
}
