package customannotation;

import java.lang.reflect.Method;

public class Fuzhitest {

	public static void main(String[] args) throws ClassNotFoundException {
		AA aa = new AA();
		// 通过反射获取类名
		Class<?> forName = Class.forName("customannotation.AA");
		// 获取到当前类（不包含继承）所有的方法
		Method[] declaredMethods = forName.getDeclaredMethods();
		for (Method method : declaredMethods) {
			// 获取该方法上是否存在注解
			Fuzhi fuzhi = method.getDeclaredAnnotation(Fuzhi.class);
			if (fuzhi != null) {
				// 该方法上没有注解
				System.out.println("####方法名称" + method.getName());
				System.out.println("该方法上有注解..");
				aa.setAa(3);
			}
		}
		System.out.println(aa.getAa());
	}

}

class AA{
private int aa;
	
	public int getAa() {
		return aa;
	}

	@Fuzhi
	public void setAa(int aa) {
		this.aa = aa;
	}
}
