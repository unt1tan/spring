package reader;

import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.reader.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private Map<String, BeanDefinition> registry;

	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}


	protected ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
}
