package cn.titan.spring.factory;

import cn.titan.spring.BeanDefine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

	Map<String, BeanDefine> beanMap = new ConcurrentHashMap<String, BeanDefine>();

	@Override
	public Object getBean(String beanName) {
		return beanMap.get(beanName).getBean();
	}

	@Override
	public void registry(String beanName, BeanDefine beanDefine) throws Exception {
		Object obj = createBean(beanDefine);
		beanDefine.setBean(obj);
		beanMap.put(beanName, beanDefine);
	}

	protected abstract Object createBean(BeanDefine beanDefine) throws Exception;
}
