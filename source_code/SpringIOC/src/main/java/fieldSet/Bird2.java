package fieldSet;

public class Bird2 {

	private String name;
	
	private int age;
	
	public Bird2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bird2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}*/

	@Override
	public String toString() {
		return "Bird [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
