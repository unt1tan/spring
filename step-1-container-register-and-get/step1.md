# 第一部分：IoC容器

## 1.step1-最基本的容器
	
	step-1-container-register-and-get

IoC最基本的角色有两个：容器(`BeanFactory`)和Bean本身。这里使用`BeanDefinition`来封装了bean对象，这样可以保存一些额外的元信息