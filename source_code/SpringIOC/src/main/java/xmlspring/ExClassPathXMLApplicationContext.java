package xmlspring;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ExClassPathXMLApplicationContext {
	//xml读取的路径地址
	private String xmlPath;
	
	public ExClassPathXMLApplicationContext(String xmlPath){
		this.xmlPath = xmlPath;
	}
	
	public Object getBean(String beanId) throws Exception{
		//1,2,3 个方法
		if(StringUtils.isEmpty(beanId)){
			throw new Exception("beanId不能为空！");
		}
		//1. 解析xml文件
		List<Element> readerXML = readerXML();
		if(readerXML == null || readerXML.isEmpty()){
			throw new Exception("配置文件中没有配置bean信息");
		}
		//2. 使用方法参数beanid查找配置文件中bean节点的id信息是否一致
		String ClassName = findByElementClass(readerXML,beanId);
		if(StringUtils.isEmpty(ClassName)){
			throw new Exception("该bean没有配置class地址");
		}		
		//3. 获取class信息地址，使用反射机制初始化
		Object newInstance = newInstance(ClassName);
		return newInstance;
	}
	
	/**
	 * 初始化对象
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object newInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		//获得类的名字
		Class<?> classInfo = Class.forName(className);
		//做初始化
		return classInfo.newInstance();
	}
	
	/**
	 * 使用方法参数beanid 查找配置文件中bean节点的id信息是否一致。返回class地址
	 * 
	 * @param readerXML
	 * @param beanId
	 * @return
	 */
	public String findByElementClass(List<Element> readerXML,String beanId){
		//每一个for循环相当于拿到一个bean的信息
		for (Element element : readerXML) {
			// 获取结点属性的值 例如id = "aa" 那么 aa就是属性值
			String xmlBeanId = element.attributeValue("id");
			if(StringUtils.isEmpty(xmlBeanId)){
				continue;  
			}
			//传进来的bean 与 xml中的bean 一致 即 找到了  直接返回class地址就ok了
			if(xmlBeanId.equals(beanId)){
				//对象的地址信息 相当于拿到了权限定名一样 所以利用了反射
				String xmlClass = element.attributeValue("class");
				return xmlClass;  //返回  结束循环
			}
		}
		//没有找到就返回null
		return null;
	}
	
	/**
	 * 解析xml文件
	 * 
	 * @return
	 * @throws DocumentException
	 */
	public List<Element> readerXML() throws DocumentException{
		//1.解析xml文件信息
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(getResourceAsStream(xmlPath));
		//2.读取根结点
		Element rootElement = document.getRootElement();
		//2.获取根结点下所有的子节点
		List<Element> elements = rootElement.elements();
		return elements;
	}
	
	
	/**
	 * 获取当前上下文路径
	 * 
	 * @param xmlPath
	 * @return
	 */
	public InputStream getResourceAsStream(String xmlPath){
		//是jdk自带的方法 不用深究 
		InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
		return xmlStream;
	}
	
}
