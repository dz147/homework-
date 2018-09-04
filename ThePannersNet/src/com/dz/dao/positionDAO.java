package com.dz.dao;

import com.dz.Interface.IpositionDAO;
import com.dz.entity.DBUtil;
import com.dz.entity.Positions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class positionDAO implements IpositionDAO{

    @Override
    public List<Positions> getPositions(int userid) {
        List<Positions> ps=new ArrayList<Positions>();
        String sql="select * from positions where userid=?";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid});
        Positions p=null;
        try {
            while(rs.next()){
                p=new Positions(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                ps.add(p);
            }
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean getAdd(Positions p) {
        String sql="insert into positions(userid,posis,pname,phone) \n" +
                "values(?,?,?,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{p.getUserid(), p.getPosis(), p.getPname(), p.getPhone()});
        if(i>0){
            return true;
        }
        return false;
    }
}
