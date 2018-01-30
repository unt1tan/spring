package cn.titan.test;

import cn.titan.spring.BeanDefine;
import cn.titan.spring.PropertyValue;
import cn.titan.spring.factory.AutowireBeanFactory;
import cn.titan.spring.factory.BeanFactory;
import cn.titan.test.service.HelloService;

public class Test {

	public static void main(String[] args) throws Exception {
		// 初始化beanfactory
		BeanFactory factory = new AutowireBeanFactory();
		// 定义bean
		BeanDefine bean = new BeanDefine(HelloService.class.getName());
		// 属性赋值
		bean.getPropertyValues().addPropertyValue(new PropertyValue("name", "titan"));
		// 注册bean
		factory.registry(bean.getBeanClass().getName(), bean);
		// 获取bean
		HelloService hello = (HelloService) factory.getBean(HelloService.class.getName());
		// 调用
		hello.helloworld();
	}
}
