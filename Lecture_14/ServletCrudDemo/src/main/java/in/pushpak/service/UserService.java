package in.pushpak.service;

import in.pushpak.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {


    // Hashmap instead of DB. with key = Integer and VALUE = User Object which stores the data such as name,id,email,mobile
    private Map<Integer, User> userDB;

    public UserService(){
        userDB = new HashMap<>(); // initialization using constructor
    }

    //create method.
    public User createUser(User userReq){  // userReq will be sent by UserServlet when we will call this method there.

        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    // get all users
    public List<User> getAllUsers(){

        List<User> usersResp = new ArrayList<>();
        for(User user : userDB.values()){  // iterating over the values of userDb with use of object user

            usersResp.add(user);
        }

        return usersResp;
    }

    // get method using id
    public User getUserById(Integer id){

        return userDB.getOrDefault(id,null);
    }


    // delete method
    public User deletedUserData(Integer id){
        if(!userDB.containsKey(id)){
            return null;
        }

        User userRes = userDB.get(id); // storing the deleting value in Object variable.
        userDB.remove(id);

        return userRes;
    }

    //update method
    public void updateUser(User userReq){
        userDB.replace(userReq.getId(),userReq);
    }



}
