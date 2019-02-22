package annotationspring2.imp;

import annotationspring2.ExtResource;
import annotationspring2.ExtService;
import annotationspring2.OrderService;
import annotationspring2.UserService;

//user 服务层
@ExtService
public class UserServiceImpl implements UserService {

	@ExtResource
	private OrderService orderServiceImpl;

	public void add() {
		orderServiceImpl.addOrder();
		System.out.println("使用java反射机制初始化对象..");
	}

}
