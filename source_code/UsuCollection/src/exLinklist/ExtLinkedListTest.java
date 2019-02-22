package exLinklist;

public class ExtLinkedListTest<E> {

	public static void main(String[] args) {
		ExtLinkedList<String> linkeList = new ExtLinkedList<String>();
		linkeList.add("A");
		linkeList.add("B");
		linkeList.add("C");
		linkeList.add("D");
		linkeList.add(0, "E");
		
		//这样也可以取到元素
		System.out.println(linkeList.getFirst().object);
		System.out.println(linkeList.getFirst().next.object);
		System.out.println(linkeList.getFirst().next.next.object);
		
		//进行调试  get(index)
		System.out.println(linkeList.get(0));
		
		System.out.println("---------利用get取元素-------------");
		for (int i = 0; i < linkeList.getSize(); i++) {
			System.out.println(linkeList.get(i));
		}
	}
	
}
