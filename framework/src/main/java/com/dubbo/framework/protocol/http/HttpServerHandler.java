package com.dubbo.framework.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.framework.Invocation;
import com.dubbo.framework.registry.LocalRegistry;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            String interfaceName = invocation.getInterfaceName();
            Object impl = LocalRegistry.getImpl(interfaceName);
            Method method = impl.getClass().getMethod(invocation.getMethodName(),invocation.getParamTypes());
            String result = (String) method.invoke(impl, invocation.getParams());
            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
