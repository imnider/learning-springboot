package imnider.learning.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class WelcomeFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("Pointcuts.routeServices()")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("@Order(1). @Before. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @After("Pointcuts.routeServices()")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("@Order(1). @After. Method: ".concat(method).concat(". Args: ").concat(args));
    }
}
