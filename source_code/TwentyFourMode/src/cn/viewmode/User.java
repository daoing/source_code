package cn.viewmode;

//用户是观察者，所以实现了抽象观察
public class User implements Observer {

	private String name;
	private String message;

	public User(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		this.message = message;
		read();
	}

	public void read() {
		System.out.println(name + " 收到推送消息： " + message);
	}

}
