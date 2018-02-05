package cn.titan.test.service;

public class WorldService {
	private String name;
	private String text;
	private HelloService service;

	public void helloworld() {
		System.out.println(name + " : " + text);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

	public HelloService getService() {
		return service;
	}
}
