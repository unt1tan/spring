package cn.titan.spring.beanfactory;

public interface BeanFactory {
	Object getBean(String beanName);

	void registry(String beanName, String beanClassName);
}
