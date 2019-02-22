package customannotrannotaionfu;
/*package customannotrannotaion;


import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;



//  自定义事务注解具体实现
@Aspect
@Component
public class AopExtTransaction_chushi {
	// 一个事务实例子 针对一个事务
	@Autowired
	private TransactionUtils transactionUtils;

	// 环绕通知 在方法之前和之后处理事情
	@Around("execution(* customannotrannotaion.*.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {

		// 1.获取代理对象的方法（百度搜在aop中如何获取代理对象的方法）
		// 获取方法名字
		String methodName = pjp.getSignature().getName();
		// 获取目标对象
		Class<?> classTarget = pjp.getTarget().getClass();
		// 获取目标对象类型
		Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
		// 获取目标对象方法
		Method objMethod = classTarget.getMethod(methodName, par);
		ExtTransaction extTransaction = objMethod.getDeclaredAnnotation(ExtTransaction.class);
		// 2.获取该方法上是否有加注解
		
		TransactionStatus transactionStatus = null;
		
		if(extTransaction != null){
			// 3.如果存在事务注解，开启事务
			transactionStatus = transactionUtils.begin();
		}
		// 4.调用目标代理对象方法
		pjp.proceed();

		// 5.判断该方法上是有注解
		if(extTransaction != null){
			// 6.如果有注解，提交事务
			transactionUtils.commit(transactionStatus);
		}		
	}

}
*/