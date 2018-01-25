package cn.titan.spring.factory;

import cn.titan.spring.BeanDefine;

public interface BeanFactory {
	Object getBean(String beanName);

	void registry(String beanName, BeanDefine beanDefine) throws Exception;
}
