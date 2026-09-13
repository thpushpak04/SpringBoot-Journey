package in.pushpak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        OrderService orderservice = context.getBean(OrderService.class);
        orderservice.placeOrder();

    }
}

/** But the problem is the classes are tightly coupled ...so to make it loose coupled... we will use the Dependency Injections and then IOC container too.
 * so, for that we used Interface PaymentService because ... we cant depend or hardcode that we will only use this payment service forever...
 * we needed that in-dependency to choose the type of payment service... like Upi or card ...
 * but the plot twist... the code is still tightly coupled as we are making the card or Upi payment object at OrderService and its not good architecture...
 *
 * so now we have to use dependency injection :- by which it means...inject your dependency from external resources like class or package...never create it by itself....
 * and for that we r creating object of orderservice at main ...but we want to take main class clean...so now we will go on next stage...
 *
 * now, we will use ApplicationContext (IOC Container)... which will create, manage and connect.
 *
 * Very Very Important :- Include the dependeny in pom.xml file using the maven repository...search for spring-context and add the dependency in pom.xml file.
 * then include ApplicationContext and AnnotationConfigApplicationContext classes in the main class.
 * 
 * Create the Appconfig class and annotate it with @Configuration and @ComonentScan("package name")
 * 
 * then use @Component annotation in the classes which we want to create object of and manage by IOC container.
 * and @Autowired annotation to inject the dependency in the class.
 *
 *
 * 
 */