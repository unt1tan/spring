package cn.titan.test.xml;

import cn.titan.spring.reader.io.ResourceLoader;
import cn.titan.spring.reader.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;

public class XmlBeanDefinitionReaderTest {
	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
		reader.loadBeanDefinitions("spring.xml");
		Assert.assertTrue(reader.getRegistry().size() > 0);
	}
}
