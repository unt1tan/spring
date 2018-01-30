# spring
简单实现spring的ioc基础功能

# IoC容器

## 1.step-1-container-register-and-get(最基本的容器)
	
IoC最基本的角色有两个：容器(`BeanFactory`)和Bean本身。这里使用`BeanDefinition`来封装了bean对象，这样可以保存一些额外的元信息

```java
// 初始化beanfactory
BeanFactory factory = new BeanFactory();
// 注册bean
factory.register(HelloService.class.getName(), new HelloService());
// 获取bean
HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());
// 调用
bean.helloworld("titan");
```

## 2.step-2-abstract-beanfactory-and-do-bean-initilizing-in-it(将bean创建放入工厂)

step1中的bean是初始化好之后再set进去的，实际使用中，我们希望容器来管理bean的创建。于是我们将bean的初始化放入BeanFactory中。为了保证扩展性，我们使用Extract Interface的方法，将`BeanFactory`替换成接口，而使用`AbstractBeanFactory`和`AutowireBeanFactory`作为其实现。"AutowireCapable"的意思是“可自动装配的”，为我们后面注入属性做准备。

```java
// 初始化beanfactory
BeanFactory factory = new AutowireBeanFactory();
// 注册bean
factory.registry(HelloService.class.getName(), "cn.titan.test.service.HelloService");
// 获取bean
HelloService bean = (HelloService) factory.getBean(HelloService.class.getName());
// 调用
bean.helloworld("titan");
```
	
## 3.step-3-inject-bean-with-property(为bean注入属性)

这一步，我们想要为bean注入属性。我们选择将属性注入信息保存成PropertyValue对象，并且保存到BeanDefinition中。这样在初始化bean的时候，我们就可以根据PropertyValue来进行bean属性的注入。Spring本身使用了setter来进行注入，这里为了代码简洁，我们使用Field的形式来注入。	

```java
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
```

## 4.step-4-config-beanfactory-with-xml(读取xml配置来初始化bean)

用xml来初始化吧。我们定义了BeanDefinitionReader初始化bean，它有一个实现是XmlBeanDefinitionReader。

```java
// 加载xml
XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
reader.loadBeanDefinitions("spring.xml");
// 注册bean
BeanFactory factory = new AutowireBeanFactory();
for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
    factory.registry(entry.getKey(), entry.getValue());
}
// 调用
HelloService hello = (HelloService) factory.getBean("helloService");
hello.helloworld();
```

## 5.step-5-inject-bean-to-bean(为bean注入bean)

使用xml配置之后，似乎里我们熟知的Spring更近了一步！但是现在有一个大问题没有解决：我们无法处理bean之间的依赖，无法将bean注入到bean中，所以它无法称之为完整的IoC容器！如何实现呢？我们定义一个`BeanReference`，来表示这个属性是对另一个bean的引用。这个在读取xml的时候初始化，并在初始化bean的时候，进行解析和真实bean的注入。

```java
// 加载xml
XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
reader.loadBeanDefinitions("spring.xml");
// 注册bean不实例化
AbstractBeanFactory factory = new AutowireBeanFactory();
for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
    factory.registry(entry.getKey(), entry.getValue());
}
// 实例化bean
factory.preInstancesingletons();
// 调用
HelloService hello = (HelloService) factory.getBean("helloService");
hello.getService().helloworld();
WorldService world = (WorldService) factory.getBean("worldService");
world.getService().helloworld();
```
同时为了解决循环依赖的问题，我们使用lazy-init的方式，将createBean的事情放到`getBean`的时候才执行，是不是一下子方便很多？这样在注入bean的时候，如果该属性对应的bean找不到，那么就先创建！因为总是先创建后注入，所以不会存在两个循环依赖的bean创建死锁的问题。
```java
for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
    Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
    declaredField.setAccessible(true);
    Object value = propertyValue.getValue();
    if (value instanceof BeanReference) {
        **BeanReference beanReference = (BeanReference) value;
        value = getBean(beanReference.getName());**
    }
    declaredField.set(bean, value);
}
```

## 6.step-6-invite-application-context(ApplicationContext登场)
	
现在BeanFactory的功能齐全了，但是使用起来有点麻烦。于是我们引入熟悉的`ApplicationContext`接口，并在`AbstractApplicationContext`的`refresh()`方法中进行bean的初始化工作。

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
helloWorldService.helloWorld();
```

至此为止，我们的spring的IoC部分可说完工了。这部分的类、方法命名和作用，都是对应Spring中相应的组件。虽然代码量只有400多行，但是已经有了基本的IoC功能！

