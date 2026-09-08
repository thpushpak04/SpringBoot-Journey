<h1>The notes for Dependency injection & Inversion of Control</h1>

so here i created an orderService class in which I'm creating object of EmailService and then using the method of it...
which makes my code dependent upon each other ....just like if there is no EmailService then there will be problem for orderService class
as it needs that EmailService class to send the message...

<b>problem 1:-</b> what if i want to switch from EmailService to smsService then i have to make the entire Logic once again
and also i have to go through major editing in code and maybe it can lead to crash of the code...
so this structure is totally depend upon each other ... and its Tightly coupled...we have to make it loose ...independent to use any tech or code ...
slightly free to connect and disconnect.

<b>Solution 1:-</b> let's create a common interface
after this we seen that still there was a problem in which the Order Service still creating the object ... we want to use
and its not good to be honest...as still there is little bit of tight coupling...
for loose coupling principle... they should receive the object from external class(services) rather than creating itself and making it dependent... or code hustling...
this is not a good practice and it avoids the SOLID principle...where a single class can do a single work ...

after this we used Constructor to intialize the object of service like EmailService we want to use...
we will create the Object using interfaces at main class and then send it using the constructor argument
at the orderService... then OrderService receives this parameter ... by using this keyword... and then we will use sendMessage method with respect to received the object
*<b>
* so for resolving the tight coupling(messed up structure - so much dependent) we have to use:-
* 1) the interfaces (override annotation too)
* 2) the construtor method
* 3) the setter method(optional to be honest)</b>

--> OrderService was deciding which implementation to use thats the problem
    * Creating Object is not a problem.,
    * Creating them in wrong place is a problem.

<h2> THE IOC is a principle whereas Dependency Injection is a approach/technique to achieve IOC.</h2>

<h3>Post Credit Scene :- at last we dont want to make so much object creation at the main, we want to make this very much clear. -> So IOC Container will come into the picture.</h3>

