package com.example.reactive_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * All about dependency injections
 * <p>
 * Marking
 * <p>
 * - Mark the class to be injected with @Component or something that builds on top of this annotation.
 * - @Bean (method level). This annotation requires that the class is marked with @Configuration
 * <p>
 * Using
 * - Mark each of the instance variable with @Autowired
 * - applicationContext.getBean(SomeClass.class);
 * <p>
 * <p>
 * This example explicitly uses all of them to show that they are kind of equivalent.
 * <p>
 * <p>
 * # Notes:
 * <p>
 * from: https://www.baeldung.com/spring-component-annotation
 * <p>
 * _@Component is a class-level annotation, but @Bean is at the method level, so @Component is only an option when a class's source code is editable. @Bean can always be used, but it's more verbose._
 * <p>
 * _@Component is compatible with Spring's auto-detection, but @Bean requires manual class instantiation._
 * <p>
 * _Using @Bean decouples the instantiation of the bean from its class definition. This is why we can use it to make even third-party classes into Spring beans. It also means we can introduce logic to decide which of several possible instance options for a bean to use._
 */

@SpringBootTest
class DependencyInjectionsTest {

    private static final String NAME = "Khongchai";

    private final GreetingHandler greetingHandlerObtainedWithAutowired;
    private final GreetingClient greetingClientObtainedWithAutowired;
    private final ApplicationContext applicationContext;


    @Autowired
    public DependencyInjectionsTest(GreetingHandler greetingHandlerObtainedWithAutowired,
                                    GreetingClient greetingClientObtainedWithAutowired,
                                    ApplicationContext applicationContext) {
        this.greetingHandlerObtainedWithAutowired = greetingHandlerObtainedWithAutowired;
        this.greetingClientObtainedWithAutowired = greetingClientObtainedWithAutowired;
        this.applicationContext = applicationContext;
    }

    @Test
    void verifyThatTheInjectedHandlersDefaultToASingletonClass() {
        final GreetingHandler handler1 = (GreetingHandler) applicationContext.getBean(GreetingHandler.class);
        final GreetingHandler handler2 = (GreetingHandler) applicationContext.getBean(GreetingHandler.class);

        Assert.state(handler1 == handler2 && handler1 == greetingHandlerObtainedWithAutowired, "Two injected handlers are equal");
    }

    @Test
    void verifyThatTheInjectedClientDefaultToASingletonClass() {
        final GreetingClient client1 = (GreetingClient) applicationContext.getBean(GreetingClient.class);
        final GreetingClient client2 = (GreetingClient) applicationContext.getBean(GreetingClient.class);

        Assert.state(client1 == client2 && greetingClientObtainedWithAutowired == client1, "Two injected clients are the same");
    }

}
