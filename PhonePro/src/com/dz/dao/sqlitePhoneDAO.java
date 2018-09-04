package com.dz.dao;

import com.dz.phone.dao.PhoneDAO;
import com.dz.phone.entity.phone;
import util.DBUtil2;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class sqlitePhoneDAO implements PhoneDAO{

    @Override
    public List<phone> getPhones() {
        List<phone> phones=new ArrayList<phone>();
        ResultSet res = DBUtil2.executeQuery("select * from product");
        phone p=null;
        try{
            while (res.next()) {
                p = new phone(res.getInt(1),
                        res.getString(2));
                phones.add(p);
            }
            return phones;
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public phone getPhoneInfo(int id) {
        return null;
    }

    @Override
    public boolean getDelete(int id) {
        return false;
    }

    @Override
    public boolean getUpdate(phone ps) {
        return false;
    }

    @Override
    public boolean getAdd(phone pInfo) {
        return false;
    }
}
