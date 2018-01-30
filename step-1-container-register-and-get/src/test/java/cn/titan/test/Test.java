package cn.titan.test;

import cn.titan.spring.BeanFactory;
import cn.titan.test.service.HelloService;

public class Test {

	public static void main(String[] args) {
		// 初始化
		BeanFactory factory = new BeanFactory();
		// 注册bean
		factory.register(HelloService.class.getName(), new HelloService());
		// 获取bean
		HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());
		// 调用
		bean.helloworld("titan");
	}
}
