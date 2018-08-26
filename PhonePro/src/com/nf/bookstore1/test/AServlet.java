package com.nf.bookstore1.test;

import com.nf.bookstore1.session.MySession;
import com.nf.bookstore1.session.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/aaa")
public class AServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MySession session = SessionFactory.getSession(req, resp);
        session.set("xxx", "hello, session");
    }
}
