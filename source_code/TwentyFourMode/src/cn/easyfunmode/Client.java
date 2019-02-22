package cn.easyfunmode;

public class Client {

	public static void main(String[] args) {
	       Factory factory = new FactoryImp();
	       Product product = factory.produce();
	       product.methodDiff();
	       product.methodSame();
	}
}
