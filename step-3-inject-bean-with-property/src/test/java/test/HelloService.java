package test;

public class HelloService {
	private String name;

	public void helloworld() {
		System.out.println(name + " : hello world");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
