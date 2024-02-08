package org.example;

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
    private final String TEST_PHRASE = "У тебя все получится!";
    @BeforeEach
    public void setUp() throws Exception{
        servlet = new ServletHelper();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        responseWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(responseWriter);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoGetServlet() throws ServletException, IOException {
        ServletHelper.list.clear();
        ServletHelper.list.add(TEST_PHRASE);
        servlet.doGet(request, response);
        Mockito.verify(response).setContentType(Mockito.eq("text/plain;charset=UTF-8"));
        assertTrue(ServletHelper.list.contains(TEST_PHRASE));
        assertEquals(1, ServletHelper.list.size());

    }

    @Test
    public void testDoPostServlet() throws ServletException, IOException {
        Mockito.when(request.getParameter("str")).thenReturn(TEST_PHRASE);
        servlet.doPost(request, response);
        assertTrue(ServletHelper.list.contains(TEST_PHRASE));
    }

}
