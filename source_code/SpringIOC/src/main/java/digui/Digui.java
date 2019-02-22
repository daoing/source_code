package digui;

public class Digui {
	
	private static boolean flag = true;
	private static int con = 0;
	private static void test1(){
		for (int i = 0; i < 10; i++) {
			//当flag = fase 时 下面这个if语句就不会进入 所以输出 1 到  9
			if(flag && (i == 6)){
				flag = false;
				System.out.println("递归");
				test1();
			}
			System.out.println("i = " + i);
		}
	}
	
	private static void test2(){
		con++;
		while(con < 10){
			System.out.println(con);
			System.out.println("===============");
			test2();
			System.out.println("反弹");
			System.out.println(con);
		}
	}
	
	
	public static void main(String[] args) {
		test1();
		test2();
	}

}
