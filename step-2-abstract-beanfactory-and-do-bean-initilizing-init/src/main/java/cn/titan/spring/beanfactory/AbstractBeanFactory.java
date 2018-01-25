package cn.titan.spring.beanfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

	Map<String, BeanDefine> beanMap = new ConcurrentHashMap<String, BeanDefine>();

	@Override
	public Object getBean(String beanName) {
		return beanMap.get(beanName).getBean();
	}

	@Override
	public void registry(String beanName, String beanClassName) {
		BeanDefine bean = createBean(beanClassName);
		beanMap.put(beanName, bean);
	}

	protected abstract BeanDefine createBean(String beanClassName);
}
