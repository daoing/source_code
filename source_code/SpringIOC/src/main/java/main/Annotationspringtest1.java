package main;

import annotationspring1.ExClassPathXMLApplicationContext;

public class Annotationspringtest1 {

	public static void main(String[] args) throws Exception {
		ExClassPathXMLApplicationContext app = new ExClassPathXMLApplicationContext("annotationspring1.imp");
		Object userService = app.getBean("userServiceImpl");
		System.out.println(userService);
	}
}
