package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.BookDAO;
import com.nf.bookstore1.dao.BookInMemoryDAO;
import com.nf.bookstore1.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/book/add")
public class BookAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/book_add_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String author = req.getParameter("author");
        String press = req.getParameter("press");

        Book book = new Book(id, name, price, author, press);

        BookDAO bookDAO = new BookInMemoryDAO();
        bookDAO.add(book);

        resp.sendRedirect("/book/index");
    }
}
