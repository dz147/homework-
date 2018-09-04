package com.dz.servlet;

import com.dz.dao.CartDAO;
import com.dz.dao.OrderDAO;
import com.dz.entity.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/carts")
public class CartServlet2 extends BaseServlet {
    PrintWriter out = null;
    CartDAO dao = new CartDAO();
    public void cartId(HttpServletRequest req, HttpServletResponse resp) {
        try {
            /*BigDecimal sum = dao.CartSum(user.getUid(), ints);
            order = new OrderFrom(user.getUid(), sum);
            boolean orAdd = dao2.getAdd(order);*/
            out = resp.getWriter();
            String[] arrs = req.getParameterValues("arr");
            req.getSession().setAttribute("arr", arrs);
            String[] arr = (String[]) req.getSession().getAttribute("arr");
            if (arr != null ) {
                    out.write("{\"msg\":\"true\"}");
            } else {
                out.write("{\"msg\":\"false\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cartAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int userId = Integer.parseInt(req.getParameter("uid"));
        int productId = Integer.parseInt(req.getParameter("pid"));
        String p = req.getParameter("price");
        BigDecimal price = new BigDecimal(p);
        Cart cart1 = dao.selectCart(userId, productId);
        if (cart1 != null) {
            boolean update = dao.getUpdate(cart1, price);
            if (update) {
                int count = dao.getCount(userId);
                out.write("{\"count\":\"" + count + "\"}");
            } else {
                out.write("{\"count\":\"0\"}");
            }
        } else {
            Cart cart = new Cart(1, userId, price, 0, productId);
            boolean add = dao.getAdd(cart);
            if (add) {
                int count = dao.getCount(userId);
                out.write("{\"count\":\"" + count + "\"}");
            } else {
                out.write("{\"count\":\"0\"}");
            }
        }
    }

    public void getSum(HttpServletRequest req, HttpServletResponse resp) {
        Users user = (Users) req.getSession().getAttribute("user");
        if (user != null) {
            try {
                out = resp.getWriter();
                BigDecimal sum = dao.getSum(user.getUid());
                if (sum != null) {
                    out.write("{\"sum\":\"" + sum + "\"}");
                } else {
                    System.out.println("gg");
                    out.write("{\"sum\":\"0.00\"}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getUpdate(HttpServletRequest req, HttpServletResponse resp) {
        Users user = (Users) req.getSession().getAttribute("user");
        int cid = Integer.parseInt(req.getParameter("cid"));//购物车ID
        int number = Integer.parseInt(req.getParameter("num"));
        String p = req.getParameter("price");//修改后的金额
        BigDecimal price = new BigDecimal(p);
        try {
            out = resp.getWriter();
            if (user != null) {
                System.out.println(number);
                boolean update = dao.getUpdate2(new Cart(cid, number, user.getUid()), price);
                if (update) {
                    BigDecimal sum = dao.getSum(user.getUid());
                    out.write("{\"sum\":\"" + sum + "\"}");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getCarts(HttpServletRequest req, HttpServletResponse resp) {
        Users user = (Users) req.getSession().getAttribute("user");
        if (user != null) {
            try {
                out = resp.getWriter();
                List<CartJoinProduct> carts = dao.getCarts(0, user.getUid());
                if (carts != null) {
                    out.write(JsonUtil.toJson(carts));
                } else {
                    out.write("{\"msg\":\"没有购买任何商品\"}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
