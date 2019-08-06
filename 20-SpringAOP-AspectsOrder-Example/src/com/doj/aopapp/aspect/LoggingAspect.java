/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Aspect
@Component
public class LoggingAspect implements Ordered {
	
	/**
	 * Declaring around advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@Around("execution(* com.doj.aopapp.service.*.transfer(*,*,*))")
	public void beforeAdviceForTransferMethods(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("****LoggingAspect Before execution of Transfer Methods " + pjp.getSignature().getName());
        pjp.proceed();
        System.out.println("****LoggingAspect After execution of Transfer Methods " + pjp.getSignature().getName());
    }

	@Override
	public int getOrder() {
		return 2;
	}
}
