package cglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

	public static void main(String[] args) {
		
		CglibProxy daoProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        //指定要代理的类
        enhancer.setSuperclass(Dao.class);
        //是指代理的对象
        enhancer.setCallback(daoProxy);
        
        //create()  为指定的类创建代理类
        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();

	}

}
