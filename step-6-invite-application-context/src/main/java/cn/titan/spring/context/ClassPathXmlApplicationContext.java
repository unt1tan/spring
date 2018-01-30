package cn.titan.spring.context;

import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.factory.AbstractBeanFactory;
import cn.titan.spring.factory.AutowireBeanFactory;
import cn.titan.spring.reader.io.ResourceLoader;
import cn.titan.spring.reader.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(this.configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registry(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}
}
