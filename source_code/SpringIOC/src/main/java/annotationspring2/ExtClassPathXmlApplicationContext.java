package annotationspring2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;



// 手写SpringIOC 注解版本
public class ExtClassPathXmlApplicationContext {
	// 扫包的范围
	private String packageName;

	//springbean容器
	private ConcurrentHashMap<String, Object> beans = null;

	public ExtClassPathXmlApplicationContext(String packageName) throws Exception {
		beans = new ConcurrentHashMap<String, Object>();
		this.packageName = packageName;
		initBeans();
		initEntryField();
	}

	// 初始化属性
	private void initEntryField() throws Exception {
		// 1.遍历所有的bean容器对象
		for (Entry<String, Object> entry : beans.entrySet()) {
			// 2.判断属性上面是否有加注解
			Object bean = entry.getValue();
			attriAssign(bean);
		}

	}

	public Object getBean(String beanId) throws Exception {
		if (StringUtils.isEmpty(beanId)) {
			throw new Exception("beanId参数不能为空");
		}
		// 1.从spring容器获取bean
		Object object = beans.get(beanId);
		// attriAssign(object);
		return object;
	}

	// 初始化对象
	public Object newInstance(Class<?> classInfo)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return classInfo.newInstance();
	}

	// 初始化对象
	public void initBeans() throws Exception {
		// 1.使用java的反射机制扫包,获取当前包下所有的类
		List<Class<?>> classes = ClassUtil.getClasses(packageName);
		// 2.判断类上是否存在注入bean的注解
		ConcurrentHashMap<String, Object> classExisAnnotation = findClassExisAnnotation(classes);
		if (classExisAnnotation == null || classExisAnnotation.isEmpty()) {
			throw new Exception("该包下没有任何类加上注解");
		}

	}

	// 判断类上是否存在注入bean的注解
	public ConcurrentHashMap<String, Object> findClassExisAnnotation(List<Class<?>> classes) throws Exception {
		for (Class<?> classInfo : classes) {
			// 判断类上是否有注解  --  
			//getDeclaredAnnotations得到的是当前成员所有的注解，不包括继承的。而getAnnotations得到的是包括继承的所有注解。
			ExtService annotation = classInfo.getAnnotation(ExtService.class);
			if (annotation != null) {
				// 获取当前类名
				String className = classInfo.getSimpleName();
				// 将当前类名变为小写
				String beanId = toLowerCaseFirstOne(className);
				Object newInstance = newInstance(classInfo);
				//key -- 对象的名字   value -- 对象的地址
				beans.put(beanId, newInstance);
			}
		}
		return beans;
	}

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// 依赖注入注解原理
	public void attriAssign(Object object) throws Exception {

		// 1.使用反射机制,获取当前类的所有属性
		Class<? extends Object> classInfo = object.getClass();
		// 获取所有的属性
		Field[] declaredFields = classInfo.getDeclaredFields();

		// 2.判断当前类属性是否存在注解
		for (Field field : declaredFields) {
			ExtResource extResource = field.getAnnotation(ExtResource.class);
			if (extResource != null) {
				// 获取属性名称
				String beanId = field.getName();
				//bean = annotationspring2.imp.OrderServiceImpl@224aed64
				//object = annotationspring2.imp.OrderServiceImpl@224aed64
				Object bean = getBean(beanId);
				if (bean != null) {
					// 3.默认使用属性名称，查找 bean容器对象 1 参数 当前对象 2 参数给属性赋值
					field.setAccessible(true); // 允许访问私有属性  作用就是让我们在用反射时访问私有变量
					// 就是给属性赋值  
					// 为什么我们可以准确的赋值呢，因为在main 中我们给出了 要赋值的属性名  userServiceImpl
					field.set(object, bean);
				}
			}
		}

	}

}
