<h1> The process of Bean Lifecycle</h1>
*
<br>

<h2>Case 1 :- Singleton Scope, Eager Initialization</h2>  
* Step 1:- The IOC Container starts using the Annotation based ApplicationContext.<br>
 <br> Application Context (Ioc container) Created <br><br>
* Step 2:- The bean definition will get create for all beans associated with @Component<br>
* Step 2:- The Ioc container will create all the objects which are associated with class and Annotation @Construct <br>
* Step 4;- Execute the Dependency Injection @Autowired <br>
<br> 
--> Types :- Construtor DI, Setter DI, Field Injection. (Constuctor DI gets preference) <br>

<br><h2> Object will create now</h2>

* Step 5:- CONSTRUCTOR will be called <br>
* Step 6;- Aware Interfaces will be called like BeanName AWARE , Application Name AWARE. <br>
* Step 7;- Initialization Interfaces will be called (Initializing Interface, init method - bean , @PostConstruct(jakarta Annotation). <br>
* Step 8;- The user defined Methods will be called.<br> 
* <br> Note :- This method is created by client itself and called by client itself.<br>

* Step 9 ;- The bean is ready to use
* 
* <br> <h2> Now Bean have to destroy </h2><br>
* Step 10 ;- Destruction Callbacks... types ;- Disposablebean, DestroyMethod, Pre Destroy( Annotation based);<br>
<br>
<br>
* Note :- use ConfigurableApplicationContext to close the IOC Container by using 
the Close method. (child class of Application Context).<br>
* Step 11 :- use @PreDestroy Annotation to destroy the bean before closing of IOC Container.<br>
*<br>
* BEAN IS DESTROYED !!<br>


*<br>
* Note :- this is the bean lifecycle of singleton Scope Bean with Eager Initialization<br>
*<br>
* <h2>Case 2 :- SINGLETON SCOPE - Lazy Initialzation </h2><br>
*<br>
* Then IOC Container will start...<br>
* Bean Definition will be created...<br>
* then Initialization will take place( related to constructor)<br>
* dependency injection will get inject<br>
*
* but... but... but... after this every step will kick-off when there will be a need by a client.<br>
*<br>
* *************<h2>CASE 3 ;- Prototype Scope **********</h2><br>
*<br>
* means every time new object and lazy( only in need )<br>
*<br>
* every step will be same ... till dependency injection....<br>
* but after that IOC container will handover that Bean(object) to user... to use as per their need.<br>
* IT WILL BECOME the OBJECT in PROTOTYPE Scope.<br>
*<br>
* So for Prototype Scope , client will not be able to use The preDestruct Annotation as<br>
* that is an Object managed by the Client not a Bean Managed by the IOC container.<br>
* IT WILL get CLEAR BY Java Garbage<br>
*<br>
* BUT, Java Garbage Collector will only free up the space cleared by object(bean)<br>
* for clearing the Resources , user have to do it manually.<br>
*<br>
* why ??<br>
* --> to avoid a memory leak...<br>
* --> will make memory(heap) full.<br>
* --> and so many beans(objects) to manage which is not possible<br>
*<br>
* Fact :- WE CAN RESOLVE THE CIRCULAR DEPENDENCY using the PostContructor Annotation<br>
*<br>