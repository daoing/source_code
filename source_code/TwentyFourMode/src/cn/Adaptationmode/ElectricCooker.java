package cn.Adaptationmode;


//电源适配器类
public class ElectricCooker {

	private JP110VInterface jp110VInterface;//日本电饭煲
	
	public ElectricCooker(JP110VInterface jp110VInterface){
		 this.jp110VInterface=jp110VInterface;
	}
	
	public void cook(){
		jp110VInterface.connect();
		System.out.println("日本电饭煲开始做饭了..");
	}
	
}
