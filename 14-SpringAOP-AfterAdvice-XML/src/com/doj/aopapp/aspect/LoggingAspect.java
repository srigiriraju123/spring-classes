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
	 * Declaring after advice 
	 * @param jp
	 * @throws Throwable
	 */
	public void afterAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring after advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	public void afterAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterAdviceForTransferMethods() " + jp.getSignature().getName());
    }
}
