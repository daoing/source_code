package annotationspring1.imp;

import annotationspring1.ExtService;
import annotationspring1.UserService;

@ExtService
public class UserServiceImpl implements UserService {
	
	public void add() {
		System.out.println("使用java反射机制初始化对象。。");
	}
}
