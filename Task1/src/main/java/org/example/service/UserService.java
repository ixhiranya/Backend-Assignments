package org.example.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

    private UserRepository userRepository;

    // 1️⃣ Constructor (Bean Creation)
    public UserService(UserRepository userRepository) {
        System.out.println("1. Constructor: Bean is being created");
        this.userRepository = userRepository;
    }

    // 2️⃣ PostConstruct
    @PostConstruct
    public void postConstruct() {
        System.out.println("2. @PostConstruct: Dependencies injected, bean initializing");
    }

    // 3️⃣ InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3. InitializingBean: afterPropertiesSet() called");
    }

    public void processUser() {
        System.out.println("4. Business Method: Processing user");
    }

    // 4️⃣ PreDestroy
    @PreDestroy
    public void preDestroy() {
        System.out.println("5. @PreDestroy: Bean about to be destroyed");
    }

    // 5️⃣ DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("6. DisposableBean: destroy() method called");
    }
}