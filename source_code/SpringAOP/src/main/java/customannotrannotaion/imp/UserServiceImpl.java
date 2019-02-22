package customannotrannotaion.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customannotrannotaion.ExtTransaction;
import customannotrannotaion.UserDao;
import customannotrannotaion.UserService;


//user 服务层
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@ExtTransaction
	public void add() {

		userDao.add("test001", 20);
		//int i = 1 / 0;
		System.out.println("################");
		userDao.add("test002", 21);
		
	}

}
