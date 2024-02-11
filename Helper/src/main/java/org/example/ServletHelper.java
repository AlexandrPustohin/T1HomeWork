package org.example;

import org.example.entity.Phrase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ServletHelper extends HttpServlet {
    static final SupportService supportservice = SupportServiceFactory.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().print(supportservice.getRandomPhrase().getPhrase());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        supportservice.addPhrase(new Phrase(req.getParameter("str")));
    }

}
