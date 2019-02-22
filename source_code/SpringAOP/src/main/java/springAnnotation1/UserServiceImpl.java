package springAnnotation1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;




//user 服务层
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionUtils transactionUtils;

	// spring 事务封装呢？ aop技术
	public void add() {
		TransactionStatus transactionStatus = null;
		try {
			// 开启事务
			transactionStatus = transactionUtils.begin();
			userDao.add("test001", 20);
			System.out.println("开始报错啦!@!!");
			//int i = 1 / 0;
			System.out.println("################");
			userDao.add("test002", 21);
			// 提交事务
			if (transactionStatus != null)
				transactionUtils.commit(transactionStatus);
		} catch (Exception e) {
			e.getMessage();
			// 回滚事务
			if (transactionStatus != null)
				transactionUtils.rollback(transactionStatus);
		}
	}

}
