package cn.titan.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

	private Map<String, BeanDefine> beanMap = new ConcurrentHashMap<String, BeanDefine>();

	public Object getBean(String beanName) {
		return beanMap.get(beanName).getBean();
	}

	public void register(String beanName, Object bean) {
		beanMap.put(beanName, new BeanDefine(bean));
	}
}
