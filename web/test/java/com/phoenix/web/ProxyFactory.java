package com.phoenix.web;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtNewMethod;

/**
 * @Auther: tianFeng
 * @Date: 2023-02-10 11:24
 */
public class ProxyFactory {
    // 代理类的class对象
    private Class clazz;
    // 代理类的实例对象
    private Object object;

    public ProxyFactory(Class clazz) {
        this.clazz = clazz;
        try {
            this.object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** 使用javassist前置增强，添加doBefore()这个方法 */
    public void doBefore(){
        System.out.println("Test Proxy Start....");
    }

    //利用javassist动态生成一个proxy类
    public Object getProxyInstance() throws Exception{

        ClassPool pool = new ClassPool(true);

        CtClass cc = pool.makeClass(clazz.getName()+"Proxy");

        cc.setSuperclass(pool.get(clazz.getName()));

        cc.addMethod(CtNewMethod.make("public void doBefore(){System.out" +   ".println(\"插入前置通知代码，Test Proxy Start...\") ;}",cc));

        CtConstructor ctc = new CtConstructor(new CtClass[]{},cc);

        ctc.setBody("{this."+clazz.getName()+"();}");//此处放入构造函数的内容，可以触发特定的处理 ，本项目只是将原来默认的构造函数原封不动地使用，如有其它需要请修改该内容即可。

        cc.addConstructor(ctc);

        Class<?> classFile =cc.toClass(); // 生成一个class对象

        Object objectTemp=classFile.newInstance();//生成新实例            　　            　                         　
        // 返回新生成的实例对象
        return objectTemp;
    }
}