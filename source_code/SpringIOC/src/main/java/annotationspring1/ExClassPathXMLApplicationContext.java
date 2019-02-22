package annotationspring1;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

//手写springioc 注解版本
public class ExClassPathXMLApplicationContext {
	//扫包的范围
	private String packageName;
	
	// springbean容器
	// Class<?> 这个是class地址
	private ConcurrentHashMap<String, Class<?>> beans = null;
	
	public ExClassPathXMLApplicationContext(String packageName) throws Exception{
		beans = new ConcurrentHashMap<String, Class<?>>();
		this.packageName = packageName;
		initBeans();
	}
	
	/**
	 * 初始化bean
	 * 
	 * @throws Exception
	 */
	public void initBeans() throws Exception{
		// 1.使用java的反射机制扫包,获取当前包下所有的类
		List<Class<?>> classes = ClassUtil.getClasses(packageName);
		// 2.判断类上是否存在注入bean的注解
		ConcurrentHashMap<String, Class<?>> classExisAnnotation = findClassExisAnnotation(classes);
		if (classExisAnnotation == null || classExisAnnotation.isEmpty()) {
			throw new Exception("该包下没有任何类加上注解");
		}
	}
	
	/**
	 * 判断类上是否存在注入bean的注解
	 * @param classes
	 * @return
	 * @throws Exception
	 */
	public ConcurrentHashMap<String, Class<?>> findClassExisAnnotation(List<Class<?>> classes) throws Exception {
		for (Class<?> classInfo : classes) {
			// 判断类上是否有注解
			ExtService annotation = classInfo.getAnnotation(ExtService.class);
			if (annotation != null) {
				// 获取当前类名
				String className = classInfo.getSimpleName();
				// 将当前类名变为小写
				String beanId = toLowerCaseFirstOne(className);
				beans.put(beanId, classInfo);
			}
		}
		return beans;
	}
	
	/**
	 * 首字母转小写
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	
	/**
	 * 初始化对象
	 * @param classInfo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object newInstance(Class<?> classInfo)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return classInfo.newInstance();
	}

	
	/**
	 * 获得bean
	 * @param beanId
	 * @return
	 * @throws Exception
	 */
	public Object getBean(String beanId) throws Exception {
		if (StringUtils.isEmpty(beanId)) {
			throw new Exception("beanId参数不能为空");
		}
		// 1.从spring容器获取bean
		Class<?> classInfo = beans.get(beanId);
		if(classInfo == null){
			throw new Exception("class not found");
		}
		// attriAssign(object);
		return newInstance(classInfo);
	}
	
}
