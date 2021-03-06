/**
 * 
 */
package com.doj.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doj.app.config.AppConfig;
import com.doj.app.repository.IAccountRepository;
import com.doj.app.service.TransferService;

/**
 * @author Manzoor Alam
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));//Reading from file system
		//BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));//Reading from class path
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//TransferService transferService = (TransferService) applicationContext.getBean("transferService");
		TransferService transferService = applicationContext.getBean(TransferService.class);
		TransferService transferService2 = applicationContext.getBean(TransferService.class);
		System.out.println(transferService == transferService2);
		IAccountRepository a1 = applicationContext.getBean(IAccountRepository.class);
		IAccountRepository a2 = applicationContext.getBean(IAccountRepository.class);
		System.out.println(a1==a2);
		//TransferService transferService =  applicationContext.getBean(TransferService.class);
		transferService.transfer("A", "B", 3000.1);
		//AccountService a2 = applicationContext.getBean(AccountService.class);
		//System.out.println(a2);
//		for(String beanName : applicationContext.getBeanDefinitionNames()){
//			System.out.println(beanName);
//		}
	}

}
