package com.dz.servlet;

import com.dz.dao.ProductDAO;
import com.dz.entity.JsonUtil;
import com.dz.entity.Product;
import com.dz.entity.Rdata;
import com.taobao.api.request.AlibabaBaichuanAppeventBatchuploadRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends BaseServlet {
    ProductDAO dao = new ProductDAO();
    PrintWriter out = null;

    public void proAdd(HttpServletRequest req, HttpServletResponse resp) {
        String pname = req.getParameter("pname");
        String price = req.getParameter("price");
        String pid = req.getParameter("pid");
        String prutrue = req.getParameter("pc");
        Product p = new Product(pname, Integer.parseInt(pid), new BigDecimal(price), "暂无", 0, prutrue);
        boolean add = dao.getAdd(p);
        try {
            out = resp.getWriter();
            if (add) {
                out.write("{\"msg\":\"添加成功\"}");
            } else {
                out.write("{\"msg\":\"添加失败\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPager(HttpServletRequest req, HttpServletResponse resp) {
        try {
            out = resp.getWriter();
            int page = Integer.parseInt(req.getParameter("page"));
            int limit = Integer.parseInt(req.getParameter("limit"));
            Rdata arr = new Rdata();
            arr.setCode(0);
            arr.setMsg("获得数据成功");
            arr.setCount(dao.getCount());
            arr.setData(dao.getProductInfo(page, limit));
            out.println(JsonUtil.toJson(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void list(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> ps = dao.getProducts(0);
        try {
            resp.getWriter().write(JsonUtil.toJson(ps));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listptid(HttpServletRequest req, HttpServletResponse resp) {
        int ptid = Integer.parseInt(req.getParameter("ptid"));
        if (ptid > 0) {
            List<Product> products = dao.getProducts(0, ptid);
            try {
                resp.getWriter().write(JsonUtil.toJson(products));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resp.getWriter().write("{\"mgs\":\"请正确输入\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void queryPros(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("pname");
        if (name != null) {
            List<Product> products = dao.getProducts(0, name);
            try {
                resp.getWriter().write(JsonUtil.toJson(products));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resp.getWriter().write("{\"mgs\":\"请正确输入\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
