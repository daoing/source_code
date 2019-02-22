package cn.singlemode;

/**
 * 饿汉法 
 * @author aura-bd
 *
 */
public class Singleton01 {   
    private static Singleton01  singleton = new Singleton01();
    private Singleton01() {}
    public static Singleton01 getSignleton(){
        return singleton;
    }
}



