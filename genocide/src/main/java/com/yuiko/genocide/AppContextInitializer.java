package com.yuiko.genocide;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {GenocideApplication.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
