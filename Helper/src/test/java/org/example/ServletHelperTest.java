package org.example;

import org.example.entity.Phrase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class ServletHelperTest extends Mockito {
    private ServletHelper servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    private SupportService supportService;

    @BeforeEach
    public void setUp() throws Exception{
        servlet = new ServletHelper();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        responseWriter = new StringWriter();
        supportService = SupportServiceFactory.getINSTANCE();
        PrintWriter writer = new PrintWriter(responseWriter);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoGetServlet() throws ServletException, IOException {
        supportService.addPhrase(new Phrase(Utils.TEST_PHRASE));
        servlet.doGet(request, response);
        Mockito.verify(response).setContentType(Mockito.eq("text/plain;charset=UTF-8"));
        assertNotNull(supportService.getRandomPhrase());
    }

    @Test
    public void testDoPostServlet() throws ServletException, IOException {
        Mockito.when(request.getParameter("str")).thenReturn(Utils.TEST_PHRASE);
        servlet.doPost(request, response);
        assertTrue(supportService.getRandomPhrase().getPhrase().equals(Utils.TEST_PHRASE));
    }

}
