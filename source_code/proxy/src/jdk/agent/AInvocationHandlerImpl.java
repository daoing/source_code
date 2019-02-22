package jdk.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 这个公共代理类是固定写法  可以简单的当做是一个工具类吧
 * @author sxd
 *
 */
public class AInvocationHandlerImpl implements InvocationHandler {
	
	//invoke 函数中要使用到
	private Object target;// 被代理的对象  即业务实现类对象，用来调用具体的业务方法  
	
	// 通过构造函数传入目标对象   
	public AInvocationHandlerImpl(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("A的代理使用jdk动态代理 开启事务");
		result = method.invoke(target, args);
		System.out.println("A的代理使用jdk动态代理 提交事务");
		return result;
	}
	
}
