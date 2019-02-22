package dom4j;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Xmlread {

	public void getcontent(String xml) throws DocumentException {
		//获取一个读流
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(getClassPath(xml));
		// 获取根节点
		Element rootElement = read.getRootElement();
		getNodes(rootElement);
	}

	//获取xml文件
	public InputStream getClassPath(String xmlPath) {
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
		return resourceAsStream;
	}

	
	//核心。。。。。 参数是根节点
	public void getNodes(Element rootElement) {
		
		System.out.println("获取当前节点名称:" + rootElement.getName());
		// 获取属性信息  //黄色波纹是因为类型安全警告 自己知道可以忽略
		// 获取根节点的属性信息 如果没有list就为空了
		@SuppressWarnings("unchecked")
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute : attributes) {
			System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
		}
		System.out.println("==================================");
		// 获取属性value
		String value = rootElement.getTextTrim();
		if (!StringUtils.isEmpty(value)) {
			System.out.println("value:" + value);
		}
		
		// 使用迭代器遍历,继续遍历子节点
		@SuppressWarnings("unchecked")
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			Element next = elementIterator.next();
			getNodes(next);
		}
	}

}
