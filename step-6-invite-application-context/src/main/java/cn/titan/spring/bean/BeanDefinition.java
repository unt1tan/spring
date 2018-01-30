package cn.titan.spring.bean;

public class BeanDefinition {
	private Object bean;
	private Class beanClass;
	private PropertyValues propertyValues;

	public BeanDefinition(String className) {
		try {
			this.beanClass = Class.forName(className);
			this.propertyValues = new PropertyValues();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}
}
