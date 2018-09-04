package com.dz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String action=req.getParameter("action");
        if(action!=null){
            try {
                // 在当前Servlet实例中根据action找到方法信息
                Method me=getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
                if(me!=null) try {
                    me.invoke(this, req, resp);

                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                else {
                    resp.getWriter().write("您请求的action不存在");
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }else{
            resp.getWriter().write("没有该方法");
        }
    }
}
