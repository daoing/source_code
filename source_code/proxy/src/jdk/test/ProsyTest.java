package jdk.test;

import java.lang.reflect.Proxy;

import org.junit.Test;

import jdk.agent.AInvocationHandlerImpl;
import jdk.ddproxy.A;
import jdk.ddproxy.Aimpl;



public class ProsyTest {
	
	@Test
	public void aProsyTest(){
		// 被代理对象
		Aimpl aImpl = new Aimpl();
		A newProxyInstance = proxy(aImpl);
		newProxyInstance.Add();
	}

	private A proxy(Aimpl aImpl) {
		AInvocationHandlerImpl ainvocationHandlerImpl = new AInvocationHandlerImpl(aImpl);
		ClassLoader aloader = aImpl.getClass().getClassLoader();
		Class<?>[] ainterfaces = aImpl.getClass().getInterfaces();
		// 主要装载器、一组接口及调用处理动态代理实例
		A newProxyInstance = (A)Proxy.newProxyInstance(aloader, ainterfaces,ainvocationHandlerImpl);
		return newProxyInstance;
	}
}
