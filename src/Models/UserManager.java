package Models;

import java.util.LinkedList;
import java.util.List;

public class UserManager {

   private List<User> users;

   public UserManager() {

       users = new LinkedList<>();
   }

   public User getUser(String name) {

       for (User user : users) {

           if (user.getName().equals(name)) {

               return user;
           }
       }

       return null;

   }

   public List<User> getAllUsers() {

       return users;
   }

   public void addMessageToAllConnectedUsers(String message) {

       for(User user: users) {

           if (user.isConnected()) {
               user.addMessage(message);
           }

       }

   }

   public void AddUser(String name) {

       users.add(new User(name, new Messsages()));
   }

   public boolean isUserNameExists(String nameToSearch) {

       boolean result = false;

       for(User user : users){

           if (user.getName().equals(nameToSearch)) {

               result = true;
           }
       }

       return result;
   }

}
