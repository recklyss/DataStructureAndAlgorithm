package DesignPatterns.Decoration;

public class Main {
    public static void main(String[] args) {
        TargetService target = new Target();
        TargetService decorator = new Decorator(target);
        decorator.fun();
    }
}
