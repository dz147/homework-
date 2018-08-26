package com.dz.dao;

import com.dz.phone.dao.PhoneDAO;
import com.dz.phone.entity.phone;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhoneIMDAO implements PhoneDAO {
    @Override
    public List<phone> getPhones() {
        List<phone> phones = new ArrayList<phone>();
        phone p = null;
        ResultSet res = DBUtil.executeQuery("select * from product");
        try {
            while (res.next()) {
                p = new phone(res.getInt(1),
                        res.getString(2),
                        res.getBigDecimal(3),
                        res.getDate(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getString(8));
                phones.add(p);
            }
            return phones;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public phone getPhoneInfo(int id) {
        phone p = null;
        ResultSet res = DBUtil.executeQuery("select * from product where id=" + id);
        try {
            if (res.next()) {
                p = new phone(res.getInt(1),
                        res.getString(2),
                        res.getBigDecimal(3),
                        res.getDate(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getString(8));
            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean getDelete(int id) {
        String mysql = "delete from product where id=?";
        int result = DBUtil.executeUpdate(mysql, new Object[]{id});
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getUpdate(phone ps) {
        String mysql = "Update product set name=?,price=?," +
                "addDate=?,Salesvolume=?,inventory=?,state=?,picture=? where id=?";
        int result = DBUtil.executeUpdate(mysql, new Object[]{ps.getName(), ps.getPrice(),
                ps.getDateTime(), ps.getSalesvolume(), ps.getInventory(), ps.getState(), ps.getPicture(), ps.getId()});
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getAdd(phone pInfo) {
        String mysql = "insert into product(`name`,price,addDate,Salesvolume,inventory,`state`,picture) " +
                "values(?,?,?,?,?,?,?)";
        int result = DBUtil.executeUpdate(mysql, new Object[]{pInfo.getName(), pInfo.getPrice(), pInfo.getDateTime(),
                pInfo.getSalesvolume(), pInfo.getInventory(), pInfo.getState(), pInfo.getPicture()});
        if(result>0){
            return true;
        }
        return false;
    }
}
