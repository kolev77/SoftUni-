package mvc.filters.demofilters;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class CaptchaInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equalsIgnoreCase("POST")) {
            String sum = request.getParameter("sum");

            if (sum == null) {
                return false;
            }

            int sumCandidate = (int) request.getSession().getAttribute("sum");

            if (sumCandidate != Integer.parseInt(sum)) {
                return false;
            }

        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        int num1 = (int) (Math.random() * 1000);
        int num2 = (int) (Math.random() * 1000);
        request.getSession().setAttribute("sum", num1 + num2);
        modelAndView.getModelMap().addAttribute("num1", num1);
        modelAndView.getModelMap().addAttribute("num2", num2);
    }
}
