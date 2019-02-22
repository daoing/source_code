package cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	
	/**
	 * Object��ʾҪ������ǿ�Ķ���
	 * Method��ʾ���صķ���
	 * Object[]�����ʾ�����б���������������Ҫ�������װ���ͣ���int-->Integer��long-Long��double-->Double
	 * MethodProxy��ʾ�Է����Ĵ���invokeSuper������ʾ�Ա�������󷽷��ĵ���
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		
		System.out.println("Before Method Invoke");
        proxy.invokeSuper(object, objects);
        System.out.println("After Method Invoke");
        
        return object;
	}

}
