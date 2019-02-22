package cn.easymode;

public class ConcreteProductA implements Product{
	@Override
	public void methodSame() {
		System.out.println("A的methodSame()");
		
	}

	@Override
	public void methodDiff() {
		System.out.println("A的methodDiff()");
		
	}
}
