package io.netty.example.my.test;

/**
 * 静态内部类方式实现单例模式：
 * 静态内部类方式实现单例巧妙地利用了 Java 类加载机制，保证其在多线程环境下的线程安全性。
 * 当一个类被加载时，其静态内部类是不会被同时加载的，只有第一次被调用时才会初始化，而且我们不能通过反射的方式获取内部的属性
 */
public class SingletonTest {
    private SingletonTest() {
    }

    public static Singleton getInstance() {
        return Singleton.instance;
    }

    static {
     System.out.println("SingletonTest被初始化了");
    }

    private static class Singleton {
        private static final Singleton instance = new Singleton();

        static {
         System.out.println("静态内部类Singleton被初始化了");
        }
    }

 public static void main(String[] args) {
  SingletonTest singletonTest = new SingletonTest();
  System.out.println("-----");
  SingletonTest.getInstance();
 }

}
