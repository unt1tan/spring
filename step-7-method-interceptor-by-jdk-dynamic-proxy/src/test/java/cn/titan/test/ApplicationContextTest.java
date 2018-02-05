package cn.titan.test;

import cn.titan.spring.context.ClassPathXmlApplicationContext;
import cn.titan.test.service.HelloService;
import cn.titan.test.service.WorldService;
import junit.framework.Assert;
import org.junit.Test;

public class ApplicationContextTest {

	@Test
	public void test() throws Exception {
		// 加载xml并注册bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		HelloService helloService = (HelloService) context.getBean("helloService");

		WorldService service = helloService.getService();
		WorldService worldService = (WorldService) context.getBean("worldService");
		Assert.assertTrue(service == worldService);
	}
}
