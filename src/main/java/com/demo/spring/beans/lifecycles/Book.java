package com.demo.spring.beans.lifecycles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component(value = "MyBook")
public class Book implements BeanPostProcessor,InitializingBean, DisposableBean {

	private int postProcessBeforeCallCount = 0;
	private int postProcessAfterCallCount  = 0;

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	private BookService bookService;

	@PostConstruct
	public void postConstruct() {
		tests("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		tests("preDestroy");
	}

	@Override
	public void destroy() throws Exception {
		tests("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		tests("afterPropertiesSet");
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		tests("postProcessAfterInitialization",(++postProcessAfterCallCount),bean.getClass().toGenericString(),beanName);
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		tests("postProcessBeforeInitialization",(++postProcessBeforeCallCount),bean.getClass().toGenericString(),beanName);
		return null;
	}

	private void tests(String callerMethodName, Object... args){
		System.out.println("-------------------------------------------");
		System.out.println("Caller Method Name : "+callerMethodName);
		System.out.println("Is Application Context null :"+(applicationContext == null));
		System.out.println("Book Service Name:"+bookService.getServiceName());
		Optional.of(args).stream().flatMap(strings -> Arrays.stream(strings)).forEach(System.out::println);
		System.out.println("-------------------------------------------");
	}
}
