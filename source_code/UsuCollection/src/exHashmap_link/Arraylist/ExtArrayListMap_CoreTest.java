package exHashmap_link.Arraylist;


public class ExtArrayListMap_CoreTest<Key, Value> {
	
	public static void main(String[] args) {
		
		ExtArrayListMap_Core<Integer, String> extArrayListMap = new ExtArrayListMap_Core<Integer,String>();
		extArrayListMap.put(1, "aa");
		extArrayListMap.put(1, "bb");
		
		System.out.println(extArrayListMap.get(1)); // aa
		
	}
}
