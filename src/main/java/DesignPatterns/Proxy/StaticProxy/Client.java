package DesignPatterns.Proxy.StaticProxy;

import DesignPatterns.Proxy.OriginalInterface;

public class Client {
    public static void main(String[] args) {
        OriginalInterface original = new Original();
        OriginalInterface proxy = new Proxy(original);
        proxy.doSomething();
    }
}
