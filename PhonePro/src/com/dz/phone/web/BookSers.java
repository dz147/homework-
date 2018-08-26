package com.dz.phone.web;

import com.dz.phone.entity.phone;
import com.dz.dao.PhoneIMDAO;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phone.html")
public class BookSers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getSession().setAttribute("phones", pInfo);
        //req.getRequestDispatcher("jsp/phone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        PhoneIMDAO phones = new PhoneIMDAO();
        List<phone> pInfo = phones.getPhones();
        resp.getWriter().write(JsonUtil.toJson(pInfo));
    }
}
