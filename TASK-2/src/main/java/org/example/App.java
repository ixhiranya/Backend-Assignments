package org.example;
import org.example.service.MessageService;
import org.example.client.GreetingClient;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App 
{
    public static void main( String[] args )
    {   //TASK-2
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        GreetingClient client=context.getBean(GreetingClient.class); //TASK-2
//        client.sendGreeting();
        MessageService service=context.getBean(MessageService.class); //TASK-3
        service.sendMessage();
        context.close();
    }
}

//TASK-5
//Building applications without spring requires
// manual instantiation of objects
// using the new keyword and wire dependencies together in main() method,
// which leads to tight coupling and heavy load of boiler plate.
//But with Spring, the framework's container takes over the entire lifecycle of your objects.
//By using Dependency Injection, Spring automatically plugs components together,
//resulting in loose coupling, easier testing, and a much more scalable architecture.
