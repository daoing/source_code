package cglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

	public static void main(String[] args) {
		
		CglibProxy daoProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        //ָ��Ҫ�������
        enhancer.setSuperclass(Dao.class);
        //��ָ����Ķ���
        enhancer.setCallback(daoProxy);
        
        //create()  Ϊָ�����ഴ��������
        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();

	}

}
