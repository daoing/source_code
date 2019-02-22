package springTrannotaion1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//user 服务层
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	//这个会触发异常通知，那么就会有回滚
	@Transactional
	public void add() {
		userDao.add("test001", 20);
		//int i = 1 / 0;
		System.out.println("################");
		userDao.add("test002", 21);

	}
	// 方法执行完毕之后，才会提交事务  //此时才会插入数据库成功

	
	
	//下面这个不会触发异常通知，那么就不会有回滚  
	//因为try的时候，就会屏蔽异常
	/*@Transactional
	public void add() {
		try {
			userDao.add("test001", 20);
			int i = 1 / 0;
			System.out.println("################");
			userDao.add("test002", 21);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
}
