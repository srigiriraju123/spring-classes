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
	 * Declaring After Throwing advice 
	 * @param jp
	 * @throws Throwable
	 */
	public void afterThrowingAdviceForAllMethods(JoinPoint jp, Exception exc) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForAllMethods() " + jp.getSignature().getName()+" Exception "+exc);
    }
	
	/**
	 * Declaring After Throwing advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	public void afterThrowingAdviceForTransferMethods(JoinPoint jp, Exception exc) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForTransferMethods() " + jp.getSignature().getName()+" Exception "+exc);
    }
	
}
