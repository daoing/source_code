package exArrylist.main;

import exArrylist.exArrylist.ExtArrayList;

public class ExArrylisttest {

	public static void main(String[] args) {
		ExtArrayList<String> extArrayList = new ExtArrayList<String>();
		extArrayList.add("zhang");
		extArrayList.add("qian");
		extArrayList.add("guo");
		System.out.println(extArrayList.get(2));
		System.out.println("*******************");
		for(int i = 0;i < extArrayList.getSize(); i++){
			System.out.println(extArrayList.get(i));
		}
		System.out.println("*******************");
		extArrayList.remove(0);
		for(int i = 0;i < extArrayList.getSize(); i++){
			System.out.println(extArrayList.get(i));
		}
		System.out.println("*******************");
		extArrayList.remove("qian");
		for(int i = 0;i < extArrayList.getSize(); i++){
			System.out.println(extArrayList.get(i));
		}
		

	}

}
