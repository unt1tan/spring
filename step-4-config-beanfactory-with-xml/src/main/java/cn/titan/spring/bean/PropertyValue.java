package cn.titan.spring.bean;

public class PropertyValue {
	private String key;
	private String value;

	public PropertyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
