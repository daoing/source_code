package cn.copymode;

import java.io.Serializable;

class Author implements Serializable{

	/**
	 * 深复制
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private int age;

    public String getName() {
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
    }

}
