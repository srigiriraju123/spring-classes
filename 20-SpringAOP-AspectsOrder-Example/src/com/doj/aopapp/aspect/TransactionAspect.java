/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Aspect
@Component
public class TransactionAspect implements Ordered{
	
	/**
	 * Declaring before advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@Before("execution(* com.doj.aopapp.service.*.transfer(*,*,*))")
	public void beforeAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****TransactionAspect.beforeAdviceForTransferMethods() " + jp.getSignature().getName());
    }

	@Override
	public int getOrder() {
		return 0;
	}
	
}
