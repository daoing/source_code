package cn.easyfunmode;

/**
 *  抽象工厂角色 (接口)
 *  工厂方法模式的核心，创建产品的类必须实现该接口
 * @author aura-bd
 *
 */
public interface Factory {
	/*创建产品的方法定义*/
	Product produce();
}
