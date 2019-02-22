package claimproxy;

// 静态代理设计模式 
// 这个类就叫做代理类
// 静态代理会new出代理对象，而动态代理是不会new出来代理对象的，而是通过反射或者字节码生成代理对象的
public class UserServiceProxy {
	private UserService userService;

	public UserServiceProxy(UserService userService) {
		this.userService = userService;
	}

	public void add() {
		System.out.println("静态代理 开启事务");
		userService.add();
		System.out.println("静态代理  提交事务");
	}

}
