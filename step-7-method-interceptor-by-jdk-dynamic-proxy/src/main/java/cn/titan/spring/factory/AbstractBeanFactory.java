package cn.titan.spring.factory;

import cn.titan.spring.bean.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<String, BeanDefinition>();

	@Override
	public Object getBean(String beanName) throws Exception {
		BeanDefinition beanDefinition = beanMap.get(beanName);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("No bean named " + beanName + " is defined");
		}
		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = createBean(beanDefinition);
		}
		return bean;
	}

	public void registry(String beanName, BeanDefinition beanDefine) {
		beanMap.put(beanName, beanDefine);
	}

	protected abstract Object createBean(BeanDefinition beanDefine) throws Exception;
}
