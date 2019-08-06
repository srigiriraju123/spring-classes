/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * @author Dinesh.Rajput
 *
 */
public class LoggingAspect {
	
	/**
	 * Declaring after-returning advice 
	 * @param jp
	 * @throws Throwable
	 */
	public void afterReturningAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterReturningAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring after-returning advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	public void afterReturningAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterReturningAdviceForTransferMethods() " + jp.getSignature().getName());
    }
}
