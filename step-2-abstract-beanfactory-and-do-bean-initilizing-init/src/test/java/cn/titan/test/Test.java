package cn.titan.test;

import cn.titan.spring.beanfactory.AutowireBeanFactory;
import cn.titan.spring.beanfactory.BeanFactory;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new AutowireBeanFactory();
		factory.registry(HelloService.class.getName(), "cn.titan.test.HelloService");

		HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());

		bean.helloworld("titan");
	}
}
