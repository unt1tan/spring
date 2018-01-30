package cn.titan.test;

public class HelloService {
	private String name;
	private String text;
	private WorldService service;

	public void helloworld() {
		System.out.println(name + " : " + text);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

	public WorldService getService() {
		return service;
	}
}
