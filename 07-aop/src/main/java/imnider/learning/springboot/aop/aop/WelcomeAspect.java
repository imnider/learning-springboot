package imnider.learning.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WelcomeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String imnider.learning.springboot.aop.services.IWelcomeService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@Before. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @After("execution(String imnider.learning.springboot.aop.services.IWelcomeService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@After. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @AfterReturning("execution(String imnider.learning.springboot.aop.services.IWelcomeService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@AfterReturning. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @AfterThrowing("execution(String imnider.learning.springboot.aop.services.IWelcomeService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("@AfterThrowing. Method: ".concat(method).concat(". Args: ").concat(args));
    }

    @Around("execution(String imnider.learning.springboot.aop.services.IWelcomeService.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        
        Object result = null;
        try {
            logger.info("@Around (Before). Method: ".concat(method).concat(". Args: ").concat(args));
            result = joinPoint.proceed();
            logger.info("@Around (After). Method: ".concat(method).concat(". Args: ").concat(args));
        } catch (Throwable e) {
            logger.error("Error has occurred: ".concat(e.getMessage()));
            throw e;
        }

        return result;
    }
}
