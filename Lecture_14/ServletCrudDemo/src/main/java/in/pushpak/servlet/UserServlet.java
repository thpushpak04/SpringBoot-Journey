package in.pushpak.servlet;

import in.pushpak.model.User;
import in.pushpak.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    // injection - tightly coupled.
    private UserService userService = new UserService();


    //*************** post -- create ****************
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(id == null || email == null ||
                name == null || mobile == null){

            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("No data received");
        }

        // if data is present, then store it.
        User user = new User(id,name,email,mobile);
        User createdUser = userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("User added successfully");
        // return json user
    }


    //************ get -- read method *****************
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        // ****** get All users segement *******
        if(idParam == null){ // if no id specified,then return all.
            // get all
           List<User> users = userService.getAllUsers();
           response.setStatus(200);
           response.setContentType("application/json");
           response.getWriter().write(usersToJson(users));
           //return users;
        }

        // ****** get user by id ******

        Integer id = Integer.parseInt(idParam);
        User userRes = userService.getUserById(id);

        if(userRes == null){
            // 404 error
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("User not found");
        }

        // return user - 200 ok ;
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userRes));


    }

    // *****************update method****************
    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(id == null || email == null ||
                name == null || mobile == null){

            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("No data received");
        }

        // if data is present, then store it.
        User user = new User(id,name,email,mobile);
        userService.updateUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("User updated successfully");


    }


    // ****************delete method ************
    @Override
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        Integer userid = Integer.parseInt(id);

        User userRes = userService.deletedUserData(userid);
        if (userRes == null){
            response.setStatus(404);
            response.setContentType("plain/text");
            response.getWriter().write("This data is not present");
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write("Your data is deleted"+"\n"+userToJson(userRes));
    }


    // METHODS to convert a user Object data to Json value manually.
    private String userToJson(User user){
        return "{\n" +
                "    \"id\" :"+ user.getId()+  "\n" +
                "    \"name\":" + user.getName()+"\n" +
                "    \"email\":"+ user.getEmail()+"\n" +
                "    \"mobile\":"+user.getMobileNo()+"\n" +
                "}";
    }

    // it expect the list of the users objects
    private String usersToJson(List<User> users){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i = 0; i<users.size(); i++){
            stringBuilder.append(usersToJson((List<User>) users.get(i)));

            if (i<users.size() - 1){
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
