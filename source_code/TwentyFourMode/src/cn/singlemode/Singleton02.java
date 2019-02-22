package cn.singlemode;


/**
 * 懒汉式
 * @author aura-bd
 *
 */
public class Singleton02 {
    private static Singleton02 singleton = null;
    private Singleton02(){}
    public static Singleton02 getSingleton() {
        if(singleton == null) singleton = new Singleton02();
        return singleton;
    }
}