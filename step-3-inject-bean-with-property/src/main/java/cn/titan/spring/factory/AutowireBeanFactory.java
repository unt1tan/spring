package cn.titan.spring.factory;

import cn.titan.spring.BeanDefine;
import cn.titan.spring.PropertyValue;

import java.lang.reflect.Field;

public class AutowireBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object createBean(BeanDefine beanDefine) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
		Object bean = beanDefine.getBeanClass().newInstance();
		for (PropertyValue propertyValue : beanDefine.getPropertyValues().getPropertyValueMap().values()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
		return bean;
	}
}