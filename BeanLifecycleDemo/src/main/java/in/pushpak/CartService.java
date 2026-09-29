package in.pushpak;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

    // Step 4:- then User defined methods will be called.
    public void getResults(){
        System.out.println("User-Defined Methods Called");
    }

    // Step 5 :- Now use @PreDestroy Annotation to Destroy the bean
    @PreDestroy
    public void lastResult(){
        System.out.println("The PreDestroy Annotation Called - Bean Destroyed");
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
 * Step 8;- The user defined Methods will be called.\
 * Step 9 ;- The bean is ready to use
 * Step 10 ;- Destruction Callbacks... types ;- Disposablebean, DestroyMethod, Pre Destroy( Annotation based);
 *
 * Note :- use ConfigurableApplicationContext to close the IOC Container by using the Close method. (child class of Application Context).
 * Step 11 :- use @PreDestroy Annotation to destroy the bean before closing of IOC Container.
 *
 * BEAN IS DESTROYED !!
 *
 * Note :- this is the bean lifecycle of singleton Scope Bean with Eager Initialization
 *
 * **********Case 2 :- SINGLETON SCOPE - Lazy Initialzation******
 *
 * Then IOC Container will start...
 * Bean Definition will be created...
 * then Initialization will take place( related to constructor)
 * dependency injection will get inject
 *
 * but... but... but... after this every step will kick-off when there will be a need by a client.
 *
 * ************* CASE 3 ;- Prototype Scope **********
 *
 * means every time new object and lazy( only in need )
 *
 * every step will be same ... till dependency injection....
 * but after that IOC container will handover that Bean(object) to user... to use as per their need.
 * IT WILL BECOME the OBJECT in PROTOTYPE Scope.
 *
 * So for Prototype Scope , client will not be able to use The preDestruct Annotation as
 * that is an Object managed by the Client not a Bean Managed by the IOC container.
 * IT WILL get CLEAR BY Java Garbage
 *
 * BUT, Java Garbage Collector will only free up the space cleared by object(bean)
 * for clearing the Resources , user have to do it manually.
 *
 * why ??
 * --> to avoid a memory leak...
 * --> will make memory(heap) full.
 * --> and so many beans(objects) to manage which is not possible
 *
 * Fact :- WE CAN RESOLVE THE CIRCULAR DEPENDENCY using the PostContructor Annotation
 */