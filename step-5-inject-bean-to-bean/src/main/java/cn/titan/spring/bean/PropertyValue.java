package cn.titan.spring.bean;

public class PropertyValue {
	private String key;
	private Object value;

	public PropertyValue(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}
}
