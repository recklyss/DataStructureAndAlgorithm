package DesignPatterns.Proxy.DynamicProxy;

import DesignPatterns.Proxy.OriginalInterface;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        OriginalInterface proxyInstance = (OriginalInterface)Proxy.newProxyInstance(OriginalInterface.class.getClassLoader(),
                new Class[]{OriginalInterface.class},
                new OriginalProxyHandler());
        proxyInstance.doSomething();
    }
}
