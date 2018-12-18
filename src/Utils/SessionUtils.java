package Utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {


    public static String getUserName(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        Object sessionAttribute = null;
        if (session != null)
        {
            sessionAttribute = session.getAttribute("UserName");
        }
        if (sessionAttribute !=null) {

            return sessionAttribute.toString();
        }

        return null;

    }

}
