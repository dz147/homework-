package com.dz.servlet;

import com.dz.dao.CartDAO;
import com.dz.dao.OrderDAO;
import com.dz.dao.positionDAO;
import com.dz.entity.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/orders")
public class orderServlet extends BaseServlet {
    CartDAO dao = new CartDAO();
    PrintWriter out = null;
    positionDAO dao1 = new positionDAO();
    OrderFrom order=null;
    OrderDAO dao2=new OrderDAO();
    public void updateCart(HttpServletRequest req,HttpServletResponse resp){
        Users user = (Users) req.getSession().getAttribute("user");
        String pid = req.getParameter("pid");
        String[] arr = (String[]) req.getSession().getAttribute("arr");
        if (user != null && arr != null) {
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            BigDecimal sum = dao.CartSum(user.getUid(), ints);
            order = new OrderFrom(user.getUid(), sum,Integer.parseInt(pid),1);
            boolean orAdd = dao2.getAdd(order);
            if(orAdd){
                int oid = dao2.getOid(user.getUid());
                System.out.println(oid);
                boolean b = dao.updateCart(user.getUid(), ints,oid);
                try {
                    out = resp.getWriter();
                    out.write("{\"bool\":\""+b+"\"}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void cartSum(HttpServletRequest req, HttpServletResponse resp){
        Users user = (Users) req.getSession().getAttribute("user");
        String[] arr = (String[]) req.getSession().getAttribute("arr");
        if (user != null && arr != null) {
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            BigDecimal bigDecimal = dao.CartSum(user.getUid(), ints);
            try {
                out = resp.getWriter();
                out.write("{\"sum\":\""+bigDecimal+"\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void posiQuery(HttpServletRequest req, HttpServletResponse resp) {
        Users user = (Users) req.getSession().getAttribute("user");
        if (user != null) {
            List<Positions> positions = dao1.getPositions(user.getUid());
            try {
                out = resp.getWriter();
                out.write(JsonUtil.toJson(positions));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void orders(HttpServletRequest req, HttpServletResponse resp) {
        Users user = (Users) req.getSession().getAttribute("user");
        String[] arr = (String[]) req.getSession().getAttribute("arr");
        if (user != null && arr != null) {
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            List<CartJoinProduct> carts = dao.getCartId(user.getUid(), ints);
            try {
                out = resp.getWriter();
                out.write(JsonUtil.toJson(carts));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
