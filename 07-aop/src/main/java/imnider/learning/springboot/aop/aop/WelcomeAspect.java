package imnider.learning.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WelcomeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String imnider.learning.springboot.aop.services.IWelcomeService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@Before. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @After("execution(String imnider.learning.springboot.aop.services.IWelcomeService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@After. Method: ".concat(method).concat(". Args: ").concat(args));
    }
}
