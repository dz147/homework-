package com.dz.servlet;

import com.dz.dao.CartDAO;
import com.dz.dao.UserDAO;
import com.dz.entity.JsonUtil;
import com.dz.entity.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserDAO dao=new UserDAO();
    CartDAO cartDAO=new CartDAO();
    public void users(HttpServletRequest req, HttpServletResponse resp){
        String acc = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        if(acc!=null&&pwd!=null){
            Users userInfo = dao.getUserInfo(acc, pwd);
            try {
                if(userInfo!=null){
                    req.getSession().setAttribute("user",userInfo);
                    resp.getWriter().write(JsonUtil.toJson(userInfo));
                }else{
                    resp.getWriter().write("{\"msg\":\"账号或密码错误\"}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                resp.getWriter().write("{\"msg\":\"登录失败\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void checkUser(HttpServletRequest req, HttpServletResponse resp){
        Users user = (Users) req.getSession().getAttribute("user");
        if(user!=null){
            try {
                int count = cartDAO.getCount(user.getUid());
                resp.getWriter().write("{\"msg\":\""+user.getUname()+"\",\"uid\":\""+user.getUid()+"\",\"count\":\""+count+"\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                resp.getWriter().write("{\"msg\":\"登录\",\"uid\":\"\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void userReg(HttpServletRequest req, HttpServletResponse resp){
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        if(account!=null&&pwd!=null&&tel!=null&&email!=null){
            Users user=new Users(account,pwd,tel,email);
            boolean add = dao.getAdd(user);
            if(add){
                try {
                    Users userInfo = dao.getUserInfo(account, pwd);
                    req.getSession().setAttribute("user",userInfo);
                    resp.getWriter().write("{\"msg\":\"注册成功\",\"uid\":\""+userInfo.getUid()+"\"}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    resp.getWriter().write("{\"msg\":\"注册失败\",\"uid\":\"\"}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
