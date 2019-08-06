/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Dinesh.Rajput
 *
 */
public class LoggingAspect {
	
	/**
	 * Declaring around advice 
	 * @param jp
	 * @throws Throwable
	 */
	public void aroundAdviceForAllMethods(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("****Before advised method execution "+jp.getSignature().getName()+" LoggingAspect.aroundAdviceForAllMethods()");
        jp.proceed();
        System.out.println("****After advised method execution "+jp.getSignature().getName()+" LoggingAspect.aroundAdviceForAllMethods()" );
        System.out.println();
    }
	
	/**
	 * Declaring around advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	public void aroundAdviceForTransferMethods(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("****Before advised method execution "+jp.getSignature().getName()+" LoggingAspect.aroundAdviceForTransferMethods()");
        jp.proceed();
        System.out.println("****After advised method execution "+jp.getSignature().getName()+" LoggingAspect.aroundAdviceForTransferMethods()" );
        System.out.println();
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.doj.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
