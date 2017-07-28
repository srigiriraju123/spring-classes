package com.doj.springapp.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Component
public class MyBeanFactoryPostProccess implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//do some logic here with bean definition
		System.out.println("Call BFPP");
	}

}
