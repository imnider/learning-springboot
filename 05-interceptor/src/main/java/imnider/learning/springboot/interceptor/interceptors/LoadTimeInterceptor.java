package imnider.learning.springboot.interceptor.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadTimeInterceptor")
public class LoadTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadTimeInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {
        logger.info("LoadingTimeInterceptor: preHandle() joining.... Method: "
            .concat(((HandlerMethod) handler).getMethod().getName()));

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);

        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;

        logger.info("Elapsed Time: ".concat(Long.toString(result)));
        logger.info("LoadingTimeInterceptor: postHandle() leaving.... Method: "
            .concat(controller.getMethod().getName()));
    }
    
}
