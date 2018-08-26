package com.nf.bookstore1.web;

import com.nf.bookstore1.dao.BookInMemoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book/del")
public class BookDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BookInMemoryDAO dao = new BookInMemoryDAO();
        String msg = null;

        if(dao.delete(id)) {
            msg = "delete 成功.";
        } else {
            msg = "delete 失败.";
        }
        //req.getRequestDispatcher("/index").forward(req, resp);
        req.getSession().setAttribute("msg", msg);

        resp.sendRedirect("/book/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("id");
        BookInMemoryDAO dao = new BookInMemoryDAO();
        // 组织成一次数据库操作，一切为了效率
        for (String id : ids) {
            dao.delete(Integer.parseInt(id));
        }

        req.getSession().setAttribute("msg", "删除成功。");

        // req.getRequestDispatcher("/index").forward(req,resp);
        resp.sendRedirect("/book/index");
    }
}
