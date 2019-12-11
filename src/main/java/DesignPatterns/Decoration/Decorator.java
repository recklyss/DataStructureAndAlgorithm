package DesignPatterns.Decoration;

public class Decorator implements TargetService {
    private TargetService target;

    public Decorator(TargetService target){
        this.target = target;
    }


    @Override
    public void fun() {
        System.out.println("方法执行之前被执行");
        target.fun();
        System.out.println("方法执行之后被执行");
    }
}
