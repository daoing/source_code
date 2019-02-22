package springAnnotation2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


//user 服务层
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public void add() {
		// 注意事项： 在使用spring事务的时候，service层 不要try 最好将异常抛出给外层aop 异常通知接受回滚  如果用try的话就会屏蔽异常，就不会触发异常通知
		try {
			userDao.add("test001", 20);
			//int i = 1 / 0;
			System.out.println("################");
			userDao.add("test002", 21);
		} catch (Exception e) {
			e.printStackTrace();
			//下面这一句是因为用了try而屏蔽了异常，使其回滚不起作用，所以我们要手动回滚。
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}
