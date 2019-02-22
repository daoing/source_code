package cn.copymode;


/**
 * 原型模式   程序员  -- 浅复制
 * @author liaowp
 *
 */
public class Programmer implements Cloneable{
    
    private String name;//名字

    private  Address address;

    public Programmer(String name,Address address){
        this.name=name;
        this.address=address;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {  
        Programmer proto = (Programmer) super.clone();  
        return proto;  
    }  
    
}
