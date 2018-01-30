package cn.titan.test;

import cn.titan.spring.beanfactory.AutowireBeanFactory;
import cn.titan.spring.beanfactory.BeanFactory;
import cn.titan.test.service.HelloService;

public class Test {

	public static void main(String[] args) {
		// 初始化
		BeanFactory factory = new AutowireBeanFactory();
		// 注册bean
		factory.registry(HelloService.class.getName(), "cn.titan.test.service.HelloService");
		// 获取bean
		HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());
		// 调用
		bean.helloworld("titan");
	}
}
