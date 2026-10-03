<h1>Notes Part -2  Spring Boot Core</h1>

Here we talked about the @Value Annotation where we used application.properties Configuration files 
by which, we can store our value to given variables in files 
using the Dependency Injection

Syntax :- @Value("${paymentGateway.type:Razorpay}")
Note :- here Razorpay is used as a Default value.

********************* Another better way to use this practice *********

--> use the ApplicationProperties.java file
which have annotations like @Component & <b>"@ConfigurationProperties"</b>

Note ;--> we use @ConfigurationProperties mostly when there are lots of variables
in application.properties and we have to store it ... so for that we map that values using this 
@ConfigurationProperties Annotation...

Further, we will use the Dependency Injection to store the values to Payment Gateway.

like the flow will be :- PaymentProperties.java(@ConfigurationProperties) ---> paymentGateway.java( using the Dependency Injection and @Autowired) and atlast just calling t
PaymentGateway at Main class.

PaymentProperties.java ----> paymentGateway.java -----> Main class.(Running class)

************************** ##### RUNNER INTERFACE ########****************

as we can see by using the Applicationcaontext and its Object context 
we were using Ioc container directly which is not a good practice, so for 
ignoring that...

we will implement the ApplicationRunner Interface

for using that... 
example :- Create one more Class like DemoRunner which implements the Application runner.
this class uses DI by Constructor DI AND @Autowired .
and at the end using a method like printResult();

so atlast, at main class a client just have to just click on run button and boom result will be there.

Note :- we can use CommandLineRunner Interface instead of ApplicationRunner Interface 
by which client can run a mvn command and result will be there 