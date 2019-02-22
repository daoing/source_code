package cn.easyfunmode;

/**
 * 2、具体工厂角色
 * 该角色实现了抽象工厂接口，具体如何创建产品就是在该类中实现 
 * @author aura-bd
 *
 */
public class FactoryImp implements Factory {
	
	@Override
	public Product produce() {
		return new ConcreteProductA();
	}
}
