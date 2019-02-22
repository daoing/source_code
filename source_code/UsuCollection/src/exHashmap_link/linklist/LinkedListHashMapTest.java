package exHashmap_link.linklist;

public class LinkedListHashMapTest {

	public static void main(String[] args) {
		LinkedListHashMap linkedListHashMap = new LinkedListHashMap();
		linkedListHashMap.put("a", "aaaa");
		linkedListHashMap.put("a", "ccccc");// 覆盖
		System.out.println(linkedListHashMap.get("a"));
	}
}

