package mian;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import customannotrannotaion.UserService;



public class Customannotrannotaiontest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("customannotrannotaion.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();

	}

}
