package Servlets;

import Models.Messsages;
import Models.User;
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

public class PostServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Gson gson = new Gson();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        User user = userManager.getUser(SessionUtils.getUserName(req));

        out.println(gson.toJson(user.getMessages()));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
