package mian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springAnnotation1.UserService;


public class SpringAnnotation1test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Transactionspring1.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();
	}

}
