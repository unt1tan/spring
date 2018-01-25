package cn.titan.test;

import cn.titan.spring.BeanFactory;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();

		factory.register(UserService.class.getName(), new UserService());

		UserService bean = (UserService) factory.getBean(UserService.class.getName());

		bean.helloworld("titan");
	}
}
