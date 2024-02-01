package org.example;

import sun.swing.BakedArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ServletHelper extends HttpServlet {
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ind =0;
        String str="";
        resp.setContentType("text/html");

        if(list.size()>0){
            str  = list.get(renInt());
        }
        resp.getWriter().print("<html><body><h1>Phrase: "+ str+"</h1></body><html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        list.add(req.getParameter("str"));
    }
    private int renInt(){
        Random rnd = new Random();
        return rnd.nextInt(list.size());
    }

}
