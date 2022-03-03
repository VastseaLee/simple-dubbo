package com.dubbo.consumer;

import com.dubbo.api.HelloService;
import com.dubbo.framework.ProxyFactory;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String res = helloService.sayHello("Young");
        System.out.println(res);
    }
}
