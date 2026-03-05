package org.example;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        UserService service = context.getBean(UserService.class);
//
//        service.processUser();
//        Could not initialize class org.springframework.beans.factory.BeanCreationException
        context.close();
    }
}