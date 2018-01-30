package cn.titan.spring.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PropertyValues {
	private final Map<String, PropertyValue> propertyValueMap = new ConcurrentHashMap<String, PropertyValue>();

	public void addPropertyValue(PropertyValue propertyValue) {
		propertyValueMap.put(propertyValue.getKey(), propertyValue);
	}

	public Map<String, PropertyValue> getPropertyValueMap() {
		return propertyValueMap;
	}
}
