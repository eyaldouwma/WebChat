package Utils;

import Models.UserManager;
import Models.Messsages;

import javax.servlet.ServletContext;

public class ServletUtils {


    public static UserManager getUserManager(ServletContext servletContext) {

        if (servletContext.getAttribute("UserManager") == null) {
            servletContext.setAttribute("UserManager",new UserManager());
        }

        return (UserManager) servletContext.getAttribute("UserManager");
    }

    public static Messsages getMessages(ServletContext servletContext) {

        if (servletContext.getAttribute("Messsages") == null) {
            servletContext.setAttribute("Messsages",new Messsages());
        }

        return (Messsages) servletContext.getAttribute("Messsages");
    }

}
