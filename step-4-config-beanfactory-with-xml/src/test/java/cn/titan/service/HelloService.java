package cn.titan.service;

public class HelloService {
	private String name;
	private String text;

	public void helloworld() {
		System.out.println(name + " : " + text);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}
}
