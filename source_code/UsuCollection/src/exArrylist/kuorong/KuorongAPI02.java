package exArrylist.kuorong;

//System.arraycopy
public class KuorongAPI02 {

	public static void main(String[] args) {
		int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
		// 参数1--src是原数组      参数 2--srcPos是 起始位置     参数 3--dest是目标数组      参数 4-- destPos是目标起始位置  参数 5 -- length 复制长度
		//从a数组的3位置  复制 4个到 b数组 中（从0位置开始） 这里面参与了覆盖
		System.arraycopy(fun, 3, fun, 0, 4);
		// 3456456
		for (int i : fun) {
			System.out.print(i);
		}
	}

}
