package mian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springAnnotation2.UserService;


public class SpringAnnotation2test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Transactionspring2.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();
	}

}
