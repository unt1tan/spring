package cn.titan.spring;

public class BeanDefine {
	private Class beanClass;
	private Object bean;
	private PropertyValues propertyValues = new PropertyValues();

	public BeanDefine(String beanClassName) {
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
}
