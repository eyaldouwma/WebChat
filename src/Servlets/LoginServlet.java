package Servlets;

import Models.LoginCallback;
import Models.UserManager;
import Utils.ServletUtils;
import Utils.SessionUtils;
import com.google.gson.Gson;
import com.sun.deploy.net.HttpRequest;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String userNameFromSession = SessionUtils.getUserName(request);
        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        if (userNameFromSession == null) {
            String userNameFromParameter = request.getParameter("UserName");

            if (userNameFromParameter.isEmpty())
            {
                out.println(gson.toJson(new LoginCallback("",false,true)));
            }
            else
            {
                if (userManager.isUserNameExists(userNameFromParameter))
                {
                    out.println(gson.toJson(new LoginCallback("That username is already in use",true,false)));
                }
                else
                {
                    userManager.AddUser(userNameFromParameter);
                    request.getSession().setAttribute("UserName",userNameFromParameter);

                    out.println(gson.toJson(new LoginCallback("",false,false)));
                }
            }
        }
        else
        {
            out.println(gson.toJson(new LoginCallback("",false,false)));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
