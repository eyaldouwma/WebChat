package Servlets;

import Models.UserManager;
import Utils.ServletUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PostUsers extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        Gson gson = new Gson();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        UserManager userManager = ServletUtils.getUserManager(getServletContext());

        out.println(gson.toJson(userManager));
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
