package DesignPatterns.Proxy.StaticProxy;

import DesignPatterns.Proxy.OriginalInterface;

public class Proxy implements OriginalInterface {
    private OriginalInterface original;

    public Proxy(OriginalInterface original) {
        this.original = original;
    }

    @Override
    public void doSomething() {
        System.out.println("做之前");
        original.doSomething();
        System.out.println("做之后");
    }
}
