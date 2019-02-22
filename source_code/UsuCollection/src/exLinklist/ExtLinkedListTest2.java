package exLinklist;

public class ExtLinkedListTest2<E> {

	public static void main(String[] args) {
			ExtLinkedList<String> extLinkedList = new ExtLinkedList<String>();
			extLinkedList.add("a");
			extLinkedList.add("b");
			extLinkedList.add("c");
			extLinkedList.add("e");
			// System.out.println("删除之前:" + extLinkedList.get(2)); // C
			extLinkedList.add(3, "f");// fabce
			// System.out.println("删除之后:" + extLinkedList.get(2));// E
			// 其实从头查到尾### 效率不高，查询算法#####折半查找
			for (int i = 0; i < extLinkedList.getSize(); i++) {
				System.out.println(extLinkedList.get(i));
			}
			// System.out.println(extLinkedList.get(2));
		}
}
	
