package com.mycompany.lunakea.spring;

import com.mycompany.lunakea.service.ProductService;
import com.mycompany.lunakea.service.RestConsumerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context3
                = new AnnotationConfigApplicationContext();

        context3.scan("com.mycompany.lunakea.service");
        context3.scan("com.mycompany.lunakea.repository");
        context3.refresh();

    }

}
