package com.web.onlineforumapi.demo;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibTest implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib after");
        return object;
    }

    public  Object getProxy(Class cls){
        //CGLIB enhancer增强类对象
        Enhancer enhancer=new Enhancer();
        //设置代理类
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象   ，对象要继承MethodInterceptor。并实现逻辑方法intercept
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) {
        CgLibTest cgLibTest = new CgLibTest();
        CarService carService = (CarService) cgLibTest.getProxy(CarService.class);
        carService.move();
    }
}
