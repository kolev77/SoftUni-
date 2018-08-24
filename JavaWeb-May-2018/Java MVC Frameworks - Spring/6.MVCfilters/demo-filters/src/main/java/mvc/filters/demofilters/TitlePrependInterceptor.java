package mvc.filters.demofilters;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TitlePrependInterceptor extends HandlerInterceptorAdapter {

    private long currentTimeBeforeExecution;
    private long currentTimeAfterExecution;
    private long currentTimeAfterViewRender;

    private final LogMessageRepository logMessageRepository;

    public TitlePrependInterceptor(LogMessageRepository logMessageRepository) {
        this.logMessageRepository = logMessageRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        currentTimeBeforeExecution = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        currentTimeAfterExecution = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        ModelMap modelMap = modelAndView.getModelMap();

        if (modelMap.containsAttribute("title")) {
            String title = (String) modelMap.get("title");
            modelMap.put("title", "SoftUni Application " + title);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        currentTimeAfterViewRender = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String message = String.format("[%s - %s] Action Execute Time: %d ms, Overall Execute Time: %d ms",
                    handlerMethod.getBeanType().getName(),
                    handlerMethod.getMethod().getName(),
                    this.currentTimeAfterExecution - this.currentTimeBeforeExecution,
                    this.currentTimeAfterViewRender - this.currentTimeBeforeExecution
            );
            Date date = new Date();
            LogMessage messageEntity = new LogMessage();
            messageEntity.setCreatedOn(date);
            messageEntity.setMessage(message);

            this.logMessageRepository.saveAndFlush(messageEntity);


        }


    }
}
