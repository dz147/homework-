package com.dz.servlet;

import com.dz.dao.positionDAO;
import com.dz.entity.JsonUtil;
import com.dz.entity.Positions;
import com.dz.entity.Users;
import com.taobao.api.request.AlibabaBaichuanAppeventBatchuploadRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/position")
public class PositionServlet extends BaseServlet {
    positionDAO dao = new positionDAO();
    PrintWriter out = null;

    public void padd(HttpServletRequest req, HttpServletResponse resp) {
        String pname = req.getParameter("pname");
        String phone = req.getParameter("phone");
        String posi = req.getParameter("position");
        Users user = (Users) req.getSession().getAttribute("user");
        if (pname != null && phone != null && posi != null && user != null) {
            Positions ps = new Positions(user.getUid(), posi, pname, phone);
            boolean add = dao.getAdd(ps);
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
    }
}
