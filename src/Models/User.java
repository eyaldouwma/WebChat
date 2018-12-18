package Models;

public class User {

    private String Name;
    private Messsages theMessagesIHaveSeen;
    private boolean isConnected = false;

    public User(String Name, Messsages messages) {

        this.Name = Name;
        theMessagesIHaveSeen = messages;
        this.isConnected = true;
    }

    public boolean isConnected() {

        return isConnected;
    }

    public void addMessage(String message) {

        theMessagesIHaveSeen.addMessage(message);

    }

    public String getName() {

        return this.Name;
    }

    public Messsages getMessages() {

        return this.theMessagesIHaveSeen;
    }
}
