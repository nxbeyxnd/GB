package ru.alexeisherkhonov.app.configurations;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/productsoap/*");
    }

    @Bean(name = "info")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("productsPort");
        definition.setLocationUri("/productsoap");
        definition.setTargetNamespace("http://alexeisherkhonov.ru/app/web/service");
        definition.setSchema(xsdSchema);
        return definition;
    }

    @Bean
    public XsdSchema xsdSchema(){
        return new SimpleXsdSchema(new ClassPathResource("/xsds/info-resource.xsd"));
    }
}
