package cn.Adaptationmode;

public class AdaptorTest {

	public static void main(String[] args) {
		CN220VInterface cn220VInterface = new CN220VInterfaceImpl();
		//参数传入电源 的值  就可以将电压调整好  此时我们只要修改中间的电压电就可以改变输出的电压
		PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
		// 电饭煲
		ElectricCooker cooker = new ElectricCooker(powerAdaptor);
		cooker.cook();//使用了适配器,在220V的环境可以工作了。
	}
	
}
