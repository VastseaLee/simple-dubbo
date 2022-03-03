package com.dubbo.provider;

import com.dubbo.framework.protocol.http.HttpServer;
import com.dubbo.framework.registry.LocalRegistry;
import com.dubbo.provider.service.HelloServiceImpl;

public class Provider {

    public static void main(String[] args) {

        LocalRegistry.register("com.dubbo.api.HelloService",new HelloServiceImpl());

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",9900);
    }
}
