package main;

import xmlspring.ExClassPathXMLApplicationContext;
import xmlspring.UserService;

public class XmlSpringtest {

	public static void main(String[] args) throws Exception {
		ExClassPathXMLApplicationContext app = new ExClassPathXMLApplicationContext("applicationContext.xml");
		UserService bean = (UserService) app.getBean("userservice");
		bean.add();

	}

}
