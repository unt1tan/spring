package factory;

import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.bean.PropertyValue;

import java.lang.reflect.Field;

public class AutowireBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object createBean(BeanDefinition beanDefine) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
		Object bean = beanDefine.getBeanClass().newInstance();
		for (PropertyValue propertyValue : beanDefine.getPropertyValues().getPropertyValueMap().values()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
		return bean;
	}
}