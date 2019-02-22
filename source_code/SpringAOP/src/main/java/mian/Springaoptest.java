package mian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springaop.UserService;

public class Springaoptest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("springaop.xml");
		UserService userService = (UserService)classPathXmlApplicationContext.getBean("userServiceImpl");
		userService.add();
	}

}
