package com.pvv.app.rest.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.DispatcherServlet;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Exaple for SpringBoot Configuration
 * 
 */
@SpringBootApplication(scanBasePackages = "com.pvv")
@EnableAspectJAutoProxy
@EnableSwagger2
public class WebConfig extends SpringBootServletInitializer {


    /**
     * Register the dispatcherServlet and loads on startup
     * 
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration( DispatcherServlet dispatcherServlet ) {
        ServletRegistrationBean registration = new ServletRegistrationBean( dispatcherServlet );
        registration.setLoadOnStartup( 1 );
        return registration;
    }

    /**
     * Starter for SprimngBoot Application
     * 
     * @param args
     */
    public static void main( String... args ) {
        SpringApplication.run( WebConfig.class, args );
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
        return application.sources( WebConfig.class );
    }

    /**
     * CommnadLinnerRunner
     * 
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner( final ApplicationContext ctx ) {
        return new CommandLineRunner(){

            @Override
            public void run( String... args ) throws Exception {
                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort( beanNames );
            }
        };
    }

   

}
