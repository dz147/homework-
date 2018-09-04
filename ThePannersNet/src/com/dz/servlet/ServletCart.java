package com.dz.servlet;

import com.dz.dao.CartDAO;
import com.dz.entity.CartJoinProduct;
import com.dz.entity.JsonUtil;
import com.dz.entity.Users;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cartList")
public class ServletCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dd");
        CartDAO dao = new CartDAO();
        PrintWriter out = null;

        Users user = (Users)request.getSession().getAttribute("user");
        if(user!=null){
           out= response.getWriter();
            List<CartJoinProduct> carts = dao.getCarts(0, user.getUid());
            System.out.println(JsonUtil.toJson(carts));
            out.println(JsonUtil.toJson(carts));
        }else{
            out.write("{\"mgs\":\"请您先登录\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
