package exArrylist.kuorong;

import java.util.Arrays;

//Arrays.copyOf
public class KuorongAPI01 {
	
		// 底层采用数组方式
		// 怎么保证集合存放无限大小---数组扩容技术
		public static void main(String[] args) {
			Object[] objects = { 1, 2 };
			System.out.println(objects.length);
			// Arrays.copyOf() 的作用 是 返回新的数组,将原来的数组的长度为2，现在扩容为10,原来本身的数据不变.
			Object[] copyNewObjects = Arrays.copyOf(objects, 10);
			System.out.println(copyNewObjects.length);
		}

}
