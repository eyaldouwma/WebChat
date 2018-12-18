package Servlets;

import Models.Messsages;
import Models.UserManager;
import Utils.ServletUtils;
import Utils.SessionUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("we are here in messages submit!");
        String userName = SessionUtils.getUserName(request);
        String theMessage = request.getParameter("Message");
        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        if (!theMessage.isEmpty()) {

            String newMessage = userName + ": " + theMessage;
            System.out.println(newMessage);
            userManager.addMessageToAllConnectedUsers(newMessage);
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


