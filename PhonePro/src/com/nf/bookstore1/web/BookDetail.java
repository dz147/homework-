package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.BookDAO;
import com.nf.bookstore1.dao.BookInMemoryDAO;
import util.JsonUtil;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/book/detail")

public class BookDetail extends HttpServlet {
    BookDAO bookDAO = new BookInMemoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.getSession().setAttribute("aaa", "222");
        req.getSession().getAttribute("aaa");

        Book book = bookDAO.getBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/jsp/book_detail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String act = req.getParameter("act");
        if (act != null && act.equals("lsid")) {
            int bid = Integer.parseInt(req.getParameter("id"));
            Book book = bookDAO.getBookById(bid);
            resp.getWriter().println(JsonUtil.toJson(book));
        }
    }
}

