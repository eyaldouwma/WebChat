package Models;

import java.util.LinkedList;
import java.util.List;

public class Messsages {

   private LinkedList<String> allMessages;


   public Messsages(){

       allMessages = new LinkedList<>();
   }

   public LinkedList<String> getAllMessages() {

       return allMessages;
   }

   public void addMessage(String message) {

       allMessages.add(message);
   }

}
