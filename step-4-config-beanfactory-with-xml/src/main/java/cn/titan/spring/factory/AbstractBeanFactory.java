package cn.titan.spring.factory;

import cn.titan.spring.bean.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<String, BeanDefinition>();

	@Override
	public Object getBean(String beanName) {
		return beanMap.get(beanName).getBean();
	}

	@Override
	public void registry(String beanName, BeanDefinition beanDefine) throws Exception {
		Object obj = createBean(beanDefine);
		beanDefine.setBean(obj);
		beanMap.put(beanName, beanDefine);
	}

	protected abstract Object createBean(BeanDefinition beanDefine) throws Exception;
}
