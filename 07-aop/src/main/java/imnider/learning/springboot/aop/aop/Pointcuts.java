package imnider.learning.springboot.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Pointcuts {
    @Pointcut("execution(String imnider.learning.springboot.aop.services.*.*(..))")
    public void routeServices(){}
}
