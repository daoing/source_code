package cn.abmode;

/**
 * 工厂抽象类
 * @author aura-bd
 *
 */
public interface AbstractFactory {
	//制造发动机
    public Engine createEngine();
    //制造空调 
    public Aircondition createAircondition(); 
}
