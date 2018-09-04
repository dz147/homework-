package com.dz.dao;

import com.dz.Interface.IuserDAO;
import com.dz.entity.DBUtil;
import com.dz.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IuserDAO {
    @Override
    public Users getUserInfo(String name, String pwd) {
        String sql="select * from users where uname=? or uphone=? or uqqyx=? and upwd=? ";
        Users user=null;
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{name,name,name, pwd});
        try {
            if(rs.next()){
                user=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean getAdd(Users user) {
        String sql="insert into users(uname,upwd,uphone,uqqyx) \n" +
                "values(?,?,?,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{user.getUname(), user.getUpwd(), user.getUphone(), user.getUqqyx()});
        if(i>0){
            return true;
        }
        return false;
    }
}
