package cn.titan.spring.beanfactory;

public class AutowireBeanFactory extends AbstractBeanFactory {
	@Override
	protected BeanDefine createBean(String beanClassName) {
		BeanDefine bean = new BeanDefine(beanClassName);
		try {
			bean.setBean(bean.getBeanClass().newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return bean;
	}
}