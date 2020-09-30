package com.web.onlineforumapi.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CarProxy implements InvocationHandler {

    //代理对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("car is run and move");
        Object object = method.invoke(target, args);
        System.out.println("car is run and move1");
        return object;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public static void main(String[] args) {
        CarInterface carInterface = new CarService();
        CarProxy carProxy = new CarProxy();
        carProxy.setTarget(carInterface);
        Object o = carProxy.createProxy();
        carInterface = (CarInterface) o;
        carInterface.move();
    }
}
