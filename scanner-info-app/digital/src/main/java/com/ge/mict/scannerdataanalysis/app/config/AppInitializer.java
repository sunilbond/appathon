package com.ge.mict.scannerdataanalysis.app.config;

import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ge.mict.scannerdataanalysis.app.config.root.RepositoryConfig;
import com.ge.mict.scannerdataanalysis.app.config.web.WebMvcConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        configureAppContextInitializers(container, SpringApplicationContextInitializer.class.getName());
        createRootAppContext(container, RepositoryConfig.class);
        createDispatcherServlet(container, WebMvcConfig.class);
    }

    private void configureAppContextInitializers(ServletContext container, String... initClassNames) {
        String initializerClasses = container.getInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM);

        String delimitedClassNames = StringUtils.arrayToDelimitedString(initClassNames, " ");

        if (StringUtils.hasText(initializerClasses)) {
            initializerClasses += " " + delimitedClassNames;
        }
        else {
            initializerClasses = delimitedClassNames;
        }

        container.setInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM, initializerClasses);
    }

    private void createRootAppContext(ServletContext container, java.lang.Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(configClasses);
        container.addListener(new ContextLoaderListener(rootContext));
    }

    private void createDispatcherServlet(ServletContext container, java.lang.Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(configClasses);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
