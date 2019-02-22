package cn.singlemode;


/**
 * 静态内部类法
 * 延时加载并且多线程是安全的
 * @author aura-bd
 *
 */
public class Singleton03 {
    private static Singleton03 singleton = null;
    private Singleton03(){}
    public static Singleton03 getSingleton() {
        if(singleton == null) singleton = new Singleton03();
        return singleton;
    }
}