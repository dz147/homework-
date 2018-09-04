package com.dz.dao;

import com.dz.Interface.IorderfromDAO;
import com.dz.entity.DBUtil;
import com.dz.entity.OrderFrom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO implements IorderfromDAO{
    @Override
    public List<OrderFrom> getOrderFroms() {
        return null;
    }
    public int getOid(int userid){
        String sql="select oid from orderfrom where userid=? and state=1 ORDER BY oid DESC limit 1";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid});
        int x=0;
        try {
            if(rs.next()){
                 x = rs.getInt(1);
                 return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public boolean getAdd(OrderFrom orderfrom) {
        String sql="insert into orderfrom(userid,prices,position,state) values(?,?,?,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{orderfrom.getUserid(), orderfrom.getPrices(),
        orderfrom.getPosition(),orderfrom.getState()});
        if(i>0){
            return true;
        }
        return false;
    }
}
