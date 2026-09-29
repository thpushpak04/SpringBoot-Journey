package in.pushpak;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CartService implements BeanNameAware, ApplicationContextAware {

    // Step 1:- Constuctor will call.
    //Construtor called
    public CartService(){
        System.out.println("Cart Service started - Constructor called");
    }

    // Step 2:- The Aware Interfaces will be called next
    // Aware Interface
    @Override
    public void setBeanName(String name) {
        System.out.println("The name of bean is: "+name);
    }
    //Aware Interface
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("The name of context is: "+applicationContext.getClass());
    }

    // Step 3:- The Initialization Interfaces will be called.
    @PostConstruct
    public void setData(){
        System.out.println("Initialization Interfaces called");
    }

    // Step 4:- Atlast User defined methods will be called.
    public void getResults(){
        System.out.println("User-Defined Methods Called");
    }
}


/*** the process of Bean LIfecycle ********
 *
 * Step 1:- The IOC Container starts using the Annotation based ApplicationContext.
 * Step 2:- The bean definition will get create for all beans associated with @Component
 * Step 2:- The Ioc container will create all the objects which are associated with class and Annotation @Construct
 * Step 4;- Execute the Dependency Injection @Autowired
 * Step 5:- CONSTRUCTOR will be called
 * Step 6;- Aware Interfaces will be called like BeanName AWARE , Application Name AWARE.
 * Step 7;- Initialization Interfaces will be called (Initializing Interface, init method - bean , @PostConstruct(jakarta Annotation).
 * Step 8;- The user defined Methods will be called.
 */