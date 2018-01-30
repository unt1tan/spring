package cn.titan.spring.context;

import cn.titan.spring.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public Object getBean(String beanName) throws Exception {
		return beanFactory.getBean(beanName);
	}

	public abstract void refresh() throws Exception;
}
