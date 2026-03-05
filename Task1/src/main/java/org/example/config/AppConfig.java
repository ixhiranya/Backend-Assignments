package org.example.config;
import org.example.service.A;
import org.example.service.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //    @Bean
//    public UserRepository userRepository() {
//        return new UserRepository();
//    }
//
//    @Bean
//    public UserService userService() {
//        return new UserService(userRepository());
//    }
//
//    @Bean
//    public A a(){
//        return new A(b());
//    }
//
//    @Bean
//    public B b(){
//        return new B(a());
//    }
    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }

}