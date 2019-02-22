package jdk.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * ��������������ǹ̶�д��  ���Լ򵥵ĵ�����һ���������
 * @author sxd
 *
 */
public class AInvocationHandlerImpl implements InvocationHandler {
	
	//invoke ������Ҫʹ�õ�
	private Object target;// ������Ķ���  ��ҵ��ʵ��������������þ����ҵ�񷽷�  
	
	// ͨ�����캯������Ŀ�����   
	public AInvocationHandlerImpl(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("A�Ĵ���ʹ��jdk��̬���� ��������");
		result = method.invoke(target, args);
		System.out.println("A�Ĵ���ʹ��jdk��̬���� �ύ����");
		return result;
	}
	
}
