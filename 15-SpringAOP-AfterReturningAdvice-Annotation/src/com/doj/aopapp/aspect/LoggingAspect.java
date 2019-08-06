/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * Declaring After Returning advice 
	 * @param jp
	 * @throws Throwable
	 */
	//@AfterReturning("execution(* com.doj.aopapp.service.*.*(..))") // After Returning advice with pointcut expression directly
	@AfterReturning("logForAllMethods()") //After Returning advice with name pointcut that declared as name logForAllMethods()
	public void afterReturningAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterReturningAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring After Returning advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@AfterReturning("execution(* com.doj.aopapp.service.*.transfer(*,*,*))")
	public void afterReturningAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterReturningAdviceForTransferMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.doj.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
