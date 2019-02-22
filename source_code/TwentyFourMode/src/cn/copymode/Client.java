package cn.copymode;

/**
 * 原型模式
 * @author liaowp
 *
 */
public class Client {
    
    public static void main(String[] args) throws CloneNotSupportedException {    
        //浅复制复制
        Address address=new Address("jx","gz");
        Programmer a=new Programmer("liaowp",address);
        a.setAddress(new Address("jx", "gz"));
        a.setName("liaowp");
        //复制
        Programmer b=(Programmer) a.clone();
        System.err.println(b.getName()+b.getAddress().getProvince()+b.getAddress().getCity());
        b.setName("pwl");
        b.getAddress().setProvince("bj");
        System.err.println(a.getName()+a.getAddress().getProvince()+a.getAddress().getCity());    
        System.err.println(b.getName()+b.getAddress().getProvince()+b.getAddress().getCity());
    }
}
