<h1> Servlet Notes</h1>

So, we divided the project into three packages such as model, Servlet and Service.

where the model package holds a class, User with getters and setters. 
(its similiar to the entity object, which is use to help to store the data temporarily)

then, the Servlet package consist of Numerous servlets like UserServlet which maps the get,post,delete and update 
Httprequest by overriding it.

Note :- WE will only use RequestParameter than the RequestBody, so its easy to parse the parameter than the body.

and Then there is a Service package in which there is UserService.java file in which we use this file to store the file.
(same as repository use to do. means it is used to store the data to the Database).

install the dependency jakarta servlet api.
Here, i used hashmap method alot. 

the manual work such as mapping the object data to sending it back as
json values are a manual work... which makes the code messy...

i personally didn't liked it.