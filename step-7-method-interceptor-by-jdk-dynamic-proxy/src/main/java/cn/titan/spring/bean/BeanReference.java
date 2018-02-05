package cn.titan.spring.bean;

public class BeanReference {
	private String name;
	private Object bean;

	public BeanReference(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
