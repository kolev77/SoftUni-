package mvc.filters.demofilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    private final TitlePrependInterceptor titlePrependInterceptor;
    private final CaptchaInterceptor captchaInterceptor;

    @Autowired
    public MyMvcConfig(TitlePrependInterceptor titlePrependInterceptor, CaptchaInterceptor captchaInterceptor) {
        this.titlePrependInterceptor = titlePrependInterceptor;
        this.captchaInterceptor = captchaInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(titlePrependInterceptor);
        registry.addInterceptor(captchaInterceptor);
    }
}
