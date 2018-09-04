package com.dz.dao;

import com.dz.Interface.IproTypeDAO;
import com.dz.entity.DBUtil;
import com.dz.entity.proType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class proTypeDAO implements IproTypeDAO{

    @Override
    public List<proType> getProTypes() {
        List<proType> types = new ArrayList<proType>();
        ResultSet rs = DBUtil.executeQuery("select * from protype");
        proType p=null;
        try {
            while (rs.next()) {
                p=new proType(rs.getInt(1),rs.getString(2));
                types.add(p);
            }
            return types;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean getAdd(String name) {
        int i = DBUtil.executeUpdate("insert into protype(pname) values(?)", new Object[]{name});
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean getDelete(int pid) {
        return false;
    }

    @Override
    public boolean getUpdate(proType p) {
        return false;
    }
}
