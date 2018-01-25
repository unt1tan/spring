package cn.titan.test;

import cn.titan.spring.BeanFactory;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();

		factory.register(HelloService.class.getName(), new HelloService());

		HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());

		bean.helloworld("titan");
	}
}
