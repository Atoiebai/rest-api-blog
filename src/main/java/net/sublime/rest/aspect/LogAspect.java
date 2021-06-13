package net.sublime.rest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public LogAspect() {
        System.out.println("Created LogAspect");
    }

    @Pointcut("within(net.sublime.rest.jwt..*)")
    public void logPointcut() {
    }

    @Before("logPointcut()")
    public void beforeLogging(@NotNull JoinPoint joinPoint) {
        logger.info("Invoke method " + joinPoint.getSignature());
    }


    @After("logPointcut()")
    public void afterLogging(@NotNull JoinPoint joinPoint) {
        logger.info("Complete method " + joinPoint.getSignature());
    }


}
