package net.sublime.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationStarter {


    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(SpringApplicationStarter.class, args);
        Object o = applicationContext.getBean("logAspect");
        System.out.println(o);
    }
}
