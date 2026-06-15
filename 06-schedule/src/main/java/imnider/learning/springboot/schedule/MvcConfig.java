package imnider.learning.springboot.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:properties/config.properties")

public class MvcConfig implements WebMvcConfigurer {
    
    private final HandlerInterceptor calendar;

    MvcConfig(@Qualifier("calendarInterceptor") HandlerInterceptor calendar) {
        this.calendar = calendar;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(calendar).addPathPatterns("/api/app/foo");
    }

}
