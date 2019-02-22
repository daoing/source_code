package exArrylist.exArrylist;

import java.util.Arrays;

/**
 * 纯手写ArrayList
 */
public class ExtArrayList<E> implements ExtList<E> {

	// 保存ArrayList中数据的数组
	private transient Object[] elementData;
	// ArrayList实际数量
	private int size;

	public ExtArrayList() {
		// 默认初始容量为10
		this(10);
	}

	public ExtArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			//和jdk中写的一样 模仿它写即可
			throw new IllegalArgumentException(initialCapacity+"初始容量不能  < 0");
		}
		// 初始化数组容量
		elementData = new Object[initialCapacity];
	}
	
	
/*	//第一种实现方式  比较好理解
	public void add(Object object) {
		elementData[size++] = object;
		// 如果存入的数据,超出了默认数组初始容量 就开始实现扩容
		//size 是全局变量 易产生线程安全问题
		if (size == elementData.length) {
			// 新的数组容量
			int newCapacity = 2 * size;
			// 实现数组扩容
			Object[] newObjct = new Object[newCapacity];
			//将老数组中的元素赋值给新的数组
			for (int i = 0; i < elementData.length; i++) {
				newObjct[i] = elementData[i];
			}
			//将新数组传给老数组
			elementData = newObjct;
		}
	}*/
	

	// 添加方法实现
	public void add(Object object) {
		//1.判断实际存放的数据容量是否大于elementData的容量，如果大于那么则扩容
		ensureExplicitCapacity(size + 1);
		elementData[size++] = object;
	}
	

	//在指定位置处插入元素
	//原理是数组移动覆盖+扩容操作
	public void add(int index, Object object) {
		rangeCheck(index);
		ensureExplicitCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = object;
		size++;
	}

	//扩容的第二种写法
	public void ensureExplicitCapacity(int minCapacity) {
		// 如果存入的数据,超出了默认数组初始容量 就开始实现扩容
		//size 是全局变量 易产生线程安全问题
		if (size == elementData.length) {
			// 获取原来数组的长度 2
			int oldCapacity = elementData.length;
			// oldCapacity >> 1 理解成 oldCapacity/2 新数组的长度是原来长度1.5倍
			int newCapacity = oldCapacity + (oldCapacity >> 1); // 3
			if (newCapacity < minCapacity) {
				// 最小容量比新容量要小的,则采用初始容量minCapacity
				newCapacity = minCapacity;
			}
			// System.out.println("oldCapacity:" + oldCapacity + ",newCapacity:"
			// + newCapacity);
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	

	// 使用下标获取数组元素
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	
	public Object remove(int index) {
		//1、使用下标查询改值是否存在
		Object object = get(index);
		//计算删删除元素后面的长度
		int numMoved = size - index - 1;
		if (numMoved > 0)
			//删除的原理就是将删除的元素后面的的元素直接都向前移动一位 做覆盖操作
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		//然后将后面的空余的置为空
		elementData[--size] = null;
		return object;
	}

	//删除对象  相同元素删除第一个
	public boolean remove(E object) {
		for (int i = 0; i < elementData.length; i++) {
			Object element = elementData[i];
			if (element.equals(object)) {
				//调用上一个remove
				remove(i);
				return true;
			}
		}
		return false;
	}

	//复制原jdk
	private void rangeCheck(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("数组越界啦!");
		}
	}

	//size是一个全局变量
	public int getSize() {
		return size;
	}

}
