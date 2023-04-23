package util;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import org.thymeleaf.TemplateEngine;

/**
 * Store and retrieves Thymeleaf TemplateEngine into the application servlet context.
 */
//注解，声明这个类是一个监听器，tomcat容器启动后被一直执行，所有的请求都首先经过监听器
@WebListener
public class TemplateEngineUtil {

    private static final String TEMPLATE_ENGINE_ATTR = "com.yiibai.thymeleaf3.TemplateEngineInstance";

    public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }

}
