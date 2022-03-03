package com.dubbo.framework.registry;

import java.util.HashMap;
import java.util.Map;

public class LocalRegistry {

    private static final Map<String,Object> map = new HashMap<>();

    public static void register(String interfaceName,Object impl){
        map.put(interfaceName,impl);
    }

    public static Object getImpl(String interfaceName){
        return map.get(interfaceName);
    }
}
