package cn.easymode;

public class ConcreteProductB implements Product{

	@Override
	public void methodSame() {
		System.out.println("B的methodSame()");		
	}

	@Override
	public void methodDiff() {
		System.out.println("B的methodDiff()");		
	}
}
