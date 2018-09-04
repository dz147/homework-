package com.dz.servlet;

import com.dz.dao.proTypeDAO;
import com.dz.entity.JsonUtil;
import com.dz.entity.proType;
import com.taobao.api.request.AlibabaBaichuanAppeventBatchuploadRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/pType")
public class ProTypeservlet extends BaseServlet {
    public void proTypes(HttpServletRequest req, HttpServletResponse resp){
        proTypeDAO dao=new proTypeDAO();
        List<proType> proTypes = dao.getProTypes();
        try {
            resp.getWriter().write(JsonUtil.toJson(proTypes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
