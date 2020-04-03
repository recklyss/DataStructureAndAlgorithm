package DesignPatterns.Singleton;

public class BadSingleton {

    private BadSingleton(){}

    private static BadSingleton INSTANCE;

    public static synchronized BadSingleton getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new BadSingleton();
        }
        return INSTANCE;
    }
}
