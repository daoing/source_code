package cn.singlemode;


/**
 * 枚举写法
 * 延时加载并且多线程是安全的
 * 且是最优的
 * 目的创建对象
 * Singleton04.INSTANCE 本身就是个对象
 * @author aura-bd
 *
 */
enum Singleton04 {
    INSTANCE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

//测试枚举写法
public class Singleton04test {
	public static void main(String[] args) {
		Singleton04.INSTANCE.setName("我是枚举写法");
		System.out.println(Singleton04.INSTANCE.getName());
	}	
}