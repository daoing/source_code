package mian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springTrannotaion1.UserService;



public class SpringTrannotaion1test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springTrannotaion1.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();

	}

}
