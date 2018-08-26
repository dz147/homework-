package com.dz.phone.web;

import com.dz.dao.PhoneIMDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/phone/del")
public class PhoneDelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        int  id = Integer.parseInt(req.getParameter("id"));
        PhoneIMDAO dao=new PhoneIMDAO();
        boolean result = dao.getDelete(id);
        if(result) {
            resp.sendRedirect("/book/index");
        }else{
            resp.getWriter().write("<h1>操作有误哦，删除失败！</h1>");
        }
    }
}
