/*package cn.net.fusen.ssm.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect @Component
public class TestAopWithAnnotation {

	@Pointcut("execution (* cn.net.fusen.ssm.controller..*.*(..))")
	public void anyMethod(){}//声明一个切入点
	
	@Before("anyMethod()")
	public void beforeAdvise(){
		System.out.println("beforeAdvise(前置通知)");
	}
	
	@AfterReturning("anyMethod()")
	public void afterReturningAdvise(){
		System.out.println("afterReturningAdvise(后置通知)");
	}
	
	@After("anyMethod()")
	public void afterAdvise(){
		System.out.println("afterAdvise(最终通知)");
	}
	
	@AfterThrowing("anyMethod()")
	public void afterThrowingAdvise(){
		System.out.println("afterThrowingAdvise(异常通知)");
	}
	
	@Around("anyMethod()")
	public void aroundAdvise(){
		System.out.println("aroundAdvise(环绕通知)");
	}
	
}
*/