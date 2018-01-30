package cn.titan.spring.reader.xml;

import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.bean.BeanReference;
import cn.titan.spring.bean.PropertyValue;
import cn.titan.spring.reader.AbstractBeanDefinitionReader;
import cn.titan.spring.reader.io.Resource;
import cn.titan.spring.reader.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		Resource resource = getResourceLoader().getResource(location);
		doReader(resource.getInputStream());
	}

	private void doReader(InputStream inputStream) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputStream);
			document.getDocumentElement();

			Element root = document.getDocumentElement();
			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if (node instanceof Element) {
					Element element = (Element) node;
					String name = element.getAttribute("name");
					String className = element.getAttribute("class");

					BeanDefinition bean = new BeanDefinition(className);
					NodeList propertyNode = element.getElementsByTagName("property");
					for (int j = 0; j < propertyNode.getLength(); j++) {
						Node ele = propertyNode.item(j);
						if (ele instanceof Element) {
							Element propertyEle = (Element) ele;
							String propertyName = propertyEle.getAttribute("name");
							String propertyValue = propertyEle.getAttribute("value");
							String propertyRef = propertyEle.getAttribute("ref");
							if (propertyRef != null && propertyRef.length() > 0) {
								BeanReference ref = new BeanReference(propertyRef);
								bean.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, ref));
							} else {
								bean.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
							}
						}
					}
					getRegistry().put(name, bean);
				}
			}
		} catch (Exception e) {
			try {
				inputStream.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
