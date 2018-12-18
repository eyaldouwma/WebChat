package Models;

public class LoginCallback {

    private String errorMessage;
    private boolean isNameExists;
    private boolean isEmpty;

    public LoginCallback(String error, boolean isNameExists, boolean isEmpty)
    {
        this.errorMessage = error;
        this.isNameExists = isNameExists;
        this.isEmpty = isEmpty;
    }
}
