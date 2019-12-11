package DesignPatterns.Decoration;

public class Target implements TargetService {

    @Override
    public void fun() {
        System.out.println("目标方法被执行");
    }
}
