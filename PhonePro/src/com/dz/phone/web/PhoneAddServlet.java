package com.dz.phone.web;

import com.dz.dao.PhoneIMDAO;
import com.dz.phone.entity.phone;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@WebServlet(value = "/phone/add")
public class PhoneAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Date de = DBUtil.date(req.getParameter("de"));
        int salesvolume =Integer.parseInt(req.getParameter("Salesvolume"));
        int inventory = Integer.parseInt(req.getParameter("inventory"));
        String picture = req.getParameter("picture");
        PhoneIMDAO dao=new PhoneIMDAO();
        phone p=new phone(name,price,de,salesvolume,inventory,1,picture);
        boolean result = dao.getAdd(p);
        System.out.println(result);
        if(result) {
            resp.sendRedirect("/book/index");
        }else{
            resp.getWriter().write("<h1>操作有误哦，添加失败！</h1>");
        }
    }
}
