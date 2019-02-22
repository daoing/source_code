package cn.easyfunmode;

/**
 * 4、具体产品角色
 * 该角色实现了抽象产品接口，负责具体不同产品的业务逻辑 
 * @author aura-bd
 *
 */
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
