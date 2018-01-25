package cn.titan.spring.beanfactory;

public class BeanDefine {
	private Class beanClass;
	private Object bean;

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
}
