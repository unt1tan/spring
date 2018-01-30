package cn.titan.spring.factory;

import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.bean.BeanReference;
import cn.titan.spring.bean.PropertyValue;

import java.lang.reflect.Field;

public class AutowireBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object createBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = beanDefinition.getBeanClass().newInstance();
		beanDefinition.setBean(bean);
		for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueMap().values()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
			declaredField.setAccessible(true);
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference ref = (BeanReference) value;
				value = getBean(ref.getName());
			}
			declaredField.set(bean, value);
		}
		return bean;
	}
}