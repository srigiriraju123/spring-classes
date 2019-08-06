package com.doj.springapp.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before BPP "+beanName);
		//CommonAnnotationBeanPostprocessor - @Autowired, @Resource, @PreDestroy, @PostConstruct etc....
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After BPP "+beanName);
		//Apply Proxy to the Object- It will create another object either subclassing or using association  
		return bean;
	}

}
