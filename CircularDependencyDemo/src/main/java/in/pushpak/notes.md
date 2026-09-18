<h1><b>Circular Dependency Injection</b></h1>

When class A depend upon Class B and Class B is inversely depend upon the class A then, it creates <br>
an ambiguity by which initialization of the object gets messy...which one to create first...as it creates<br>
the cycle/ loop ... so<br>

this is not a Spring problem... this is Code Quality problem... we should avoid Circular Dependency in<br> 
every situation as it can make things go wrong...<br>
so, every class should execute one property ...<br>

as an example :- OrderService is depended upon paymentService and inversely PaymentService is depended upon<br>
the OrderService ... by which it cause the problem...<br>

so look for the things like why we are using the OrderService in Payment service...whats the need of displaying<br>
Orderlist using the paymentService ... so try to avoid this.<br>