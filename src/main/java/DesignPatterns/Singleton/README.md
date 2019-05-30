#### 单例模式
单例模式是创建型模式最简单之一，它的作用是为某一个类提供访问这个类对象的唯一方式即每次访问的类对象都是同一实例。

##### [饿汉型单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/blob/master/src/main/java/DesignPatterns/Singleton/HungrySingleton.java)
- 在类创建的时候就创建对象。
    - 优点：方便高效，类加载机制保证线程安全。
    - 缺点：使用较少的场合下资源浪费，不能延迟加载
##### [懒汉型单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/blob/master/src/main/java/DesignPatterns/Singleton/LazySingleton.java)
- 在调用获取实例方法的时候创建对象
    - 优点：懒加载模式保证资源不被浪费
    - 缺点：线程不安全
##### [静态内部类单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/tree/master/src/main/java/DesignPatterns/Singleton/StaticInnerClassSingleton.java)
- 在单例类中使用静态内部类创建对象
    - 优点：线程安全，资源利用率高，兼备了并发高效调用和延迟加载的优势
    - 缺点：xxx
##### [双重锁单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/blob/master/src/main/java/DesignPatterns/Singleton/DoubleLockSingleton.java)
- 使用双重加锁，静态变量使用volatile修饰保证可见性，屏蔽创建对象的指令重排序，代码块使用synchronized修饰保证同步
    - 优点：线程安全，延迟加载
    - 缺点：同步机制消耗性能
##### [使用CAS创建单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/blob/master/src/main/java/DesignPatterns/Singleton/CASSingleton.java)
- 使用CAS创建单例，完全可以实现线程安全，相较于双重锁单例能够很大程度上提高程序性能
    - 优点：线程安全，延迟加载，性能好
    - 缺点：xxx
##### [使用枚举创建单例](https://github.com/Fatezhang/DataStructureAndAlgorithm/blob/master/src/main/java/DesignPatterns/Singleton/EnumSingleton.java)
- 枚举类本身就是单例的
    - 优点：线程安全，代码简洁
    - 缺点：无延迟加载
##### 单例如何防止反序列化被破坏以及原理
- 除了枚举类，上述其他几种单例模式都会被反射或者反序列化破坏。
- 防止被反序列化破坏单例，就需要在单例中定义一个方法：
    ```aidl
    // 重写该方法，防止序列化和反序列化获取实例
    private Object readResolve() throws ObjectStreamException{
        // 返回单例实例对象
        return instance;
    }
    ```
