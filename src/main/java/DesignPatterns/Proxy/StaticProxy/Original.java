package DesignPatterns.Proxy.StaticProxy;

import DesignPatterns.Proxy.OriginalInterface;

public class Original implements OriginalInterface {
    @Override
    public void doSomething() {
        System.out.println("我在干我原始的事情~~");
    }
}
