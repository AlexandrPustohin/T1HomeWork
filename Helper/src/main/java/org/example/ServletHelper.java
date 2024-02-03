package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ServletHelper extends HttpServlet {
    static ArrayList<String> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str="";
        resp.setContentType("text/plain;charset=UTF-8");

        if(list.size()>0){
            str  = list.get(renInt());
        }
        resp.getWriter().print(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        list.add(req.getParameter("str"));
    }
    private int renInt(){
        Random rnd = new Random();
        return rnd.nextInt(list.size());
    }

}
