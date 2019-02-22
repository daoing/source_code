package mian;

import claimproxy.UserService;
import claimproxy.UserServiceImpl;
import claimproxy.UserServiceProxy;

public class Claimproxytest {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
		userServiceProxy.add();
		
	}

}
