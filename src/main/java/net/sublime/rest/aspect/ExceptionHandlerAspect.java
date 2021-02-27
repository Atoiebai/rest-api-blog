package net.sublime.rest.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {

    public ExceptionHandlerAspect() {
        System.out.println("Created ExceptionHandlerAspect");
    }

    @Pointcut("within(net.sublime.rest.service.user..*)")
    public void exceptionPointcut() {}

    @AfterThrowing("exceptionPointcut()")
    public void substituteToArithmetic() {
        // TODO: 2/28/2021 Some handle logic
    }
}