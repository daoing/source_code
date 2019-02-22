package main;

import annotationspring2.ExtClassPathXmlApplicationContext;
import annotationspring2.UserService;

public class annotationspringtest2 {

	public static void main(String[] args) throws Exception {
		
		ExtClassPathXmlApplicationContext app = new ExtClassPathXmlApplicationContext("annotationspring2.imp");
		UserService userService = (UserService) app.getBean("userServiceImpl");
		userService.add();
		System.out.println(userService);

	}

}
