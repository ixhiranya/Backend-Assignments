package org.example;

import org.example.client.GreetingClient;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingClient client=context.getBean(GreetingClient.class);
        client.sendGreeting();
        context.close();
    }
}
