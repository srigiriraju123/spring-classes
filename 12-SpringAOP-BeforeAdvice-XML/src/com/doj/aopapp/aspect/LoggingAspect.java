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
	 * Declaring before advice 
	 * @param jp
	 * @throws Throwable
	 */
	public void beforeAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.beforeAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring before advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	public void beforeAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.beforeAdviceForTransferMethods() " + jp.getSignature().getName());
    }
}
