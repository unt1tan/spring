package test;

import cn.titan.spring.BeanDefine;
import cn.titan.spring.PropertyValue;
import cn.titan.spring.factory.AutowireBeanFactory;
import cn.titan.spring.factory.BeanFactory;

public class Test {

	public static void main(String[] args) throws Exception {
		BeanFactory factory = new AutowireBeanFactory();

		BeanDefine bean = new BeanDefine(HelloService.class.getName());

		bean.getPropertyValues().addPropertyValue(new PropertyValue("name", "titan"));

		factory.registry(bean.getBeanClass().getName(), bean);

		HelloService hello = (HelloService) factory.getBean(HelloService.class.getName());

		hello.helloworld();
	}
}
