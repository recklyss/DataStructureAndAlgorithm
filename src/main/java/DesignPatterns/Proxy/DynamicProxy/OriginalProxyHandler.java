package DesignPatterns.Proxy.DynamicProxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class OriginalProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "被执行了");
        method.invoke(proxy, args);
        System.out.println("在执行之后");
        return "invoke";
    }
}
