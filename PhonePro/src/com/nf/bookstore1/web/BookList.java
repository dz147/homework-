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
import java.util.List;
@WebServlet(value = "/book/bookInfo")
public class BookList extends HttpServlet {
    BookDAO bookDAO = new BookInMemoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = bookDAO.listAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/jsp/book_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action.equals("list")){
            List<Book> books = bookDAO.listAll();
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(JsonUtil.toJson(books));
            getSleep();
        }else{
            resp.getWriter().println("{\"msg\":\"有误\"}");
        }

    }
        public void getSleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
