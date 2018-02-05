package cn.titan.spring.factory;

public interface BeanFactory {
	Object getBean(String beanName) throws Exception;
}
