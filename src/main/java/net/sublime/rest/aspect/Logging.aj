package net.sublime.rest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Pointcut("within(net.sublime.rest.. *)")
    public void logPointcut() {}

    @Before("logPointcut()")
    public void beforeLogging(JoinPoint joinPoint) {
        System.out.println("Invoke method " + joinPoint.getSignature());

    }

    @After("logPointcut()")
    public void afterLogging(JoinPoint joinPoint) {
        System.out.println("Complete method " + joinPoint.getSignature());
    }
}
