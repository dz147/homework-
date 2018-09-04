package com.dz.dao;

import com.dz.Interface.IproductDAO;
import com.dz.entity.DBUtil;
import com.dz.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IproductDAO {
    //上架产品
    @Override
    public List<Product> getProducts(int state) {
        List<Product> products = new ArrayList<Product>();
        Product product = null;
        String sql = "select * from product where state=?";
        return getList(sql,new Object[]{state});
    }
    public int getCount(){
        String sql="select COUNT(*) from product";
        ResultSet rs = DBUtil.executeQuery(sql);
        int count=0;
        try {
            if(rs.next()){
                count=rs.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<Product> getProductInfo(int page,int limit) {
        int start=(page-1)*limit;//开始
        List<Product> products = new ArrayList<Product>();
        Product product = null;
        String sql = "select * from product  order by pno limit ?,?";
        return getList(sql,new Object[]{start,limit});
    }
    //上架+类型ID
    @Override
    public List<Product> getProducts(int state, int ptid) {

        List<Product> products = new ArrayList<Product>();
        Product product = null;
        String sql = "select * from product where state=? and ptid=?";
        return getList(sql,new Object[]{state,ptid});
    }
    //查询单个产品
    public Product getPrice(int state, int pid) {
        String sql = "select * from product where state=? and pno=?";
        ResultSet rs=DBUtil.executeQuery(sql,new Object[]{state,pid});
        Product product=null;
        try {
            while (rs.next()) {
                product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBigDecimal(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //通用查询返回商品集合
    public List<Product> getList(String sql,Object[] obj) {
        List<Product> products = new ArrayList<Product>();
        ResultSet rs = DBUtil.executeQuery(sql, obj);
        Product product=null;
        try {
            while (rs.next()) {
                product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBigDecimal(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询上架，与模糊匹配
    @Override
    public List<Product> getProducts(int state, String name) {
        List<Product> products = new ArrayList<Product>();
        Product product = null;
        String sql = "select * from product where state=? and pname like '%"+name+"%'";
        return getList(sql,new Object[]{state});
    }

    //添加产品
    @Override
    public boolean getAdd(Product p) {
        String sql = "insert into product(pname,ptid,price,details,state,prcture)\n" +
                "values(?,?,?,'暂无',0,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{p.getPname(), p.getPtid(),
                p.getPrice(), p.getPrcture()});
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getDelete(int id) {
        return false;
    }

    @Override
    public boolean getUpdate(Product product) {
        return false;
    }
}
