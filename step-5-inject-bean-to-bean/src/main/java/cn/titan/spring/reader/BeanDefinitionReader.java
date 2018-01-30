package cn.titan.spring.reader;

public interface BeanDefinitionReader {
	void loadBeanDefinitions(String location) throws Exception;
}
