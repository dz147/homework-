package com.dz.dao;

import com.dz.Interface.IcartDAO;
import com.dz.entity.Cart;
import com.dz.entity.CartJoinProduct;
import com.dz.entity.DBUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements IcartDAO {
    //查询购物车
    @Override
    public List<CartJoinProduct> getCarts(int state, int userid) {
        String sql = "select c.cid,p.prcture,p.pname,p.price,c.number,c.prices from product p join cart c on c.p_id=p.pno where userid=? and ststus=?";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid, state});
        List<CartJoinProduct> cartList = new ArrayList<CartJoinProduct>();
        CartJoinProduct c = null;
        try {
            while (rs.next()) {
                c = new CartJoinProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBigDecimal(4),
                        rs.getInt(5),
                        rs.getBigDecimal(6));
                cartList.add(c);
            }
            return cartList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cart selectCart(int userid, int pid) {
        String sql = "select * from cart where userid=? and p_id=? and ststus=0";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid, pid});
        Cart ca = null;
        try {
            if (rs.next()) {
                ca = new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getBigDecimal(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
                return ca;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateCart(int userid, int[] cid,int oid){
        String sql = "update cart set ststus=1,\n" +
                "o_id="+oid+" \n" +
                "where userid=" + userid + " and ststus=0 and cid in (";
        String str = "";
        for (int i = 0; i < cid.length; i++) {
            sql += str + "" + cid[i] + "";
            if (i == cid.length - 1) {
                sql += ")";
                continue;
            }
            str = ",";
        }
        int i = DBUtil.executeUpdate(sql);
        if(i>0){
            return true;
        }
        return false;
    }
        /*public boolean updateCart(int userid, int[] cid){
            String sql = "update cart set \n" +
                    "ststus=1 \n" +
                    "where userid=" + userid + " and ststus=0 and cid in (";
            String str = "";
            for (int i = 0; i < cid.length; i++) {
                sql += str + "" + cid[i] + "";
                if (i == cid.length - 1) {
                    sql += ")";
                    continue;
                }
                str = ",";
            }
            int i = DBUtil.executeUpdate(sql);
            if(i>0){
                return true;
            }
            return false;
        }*/
        public BigDecimal CartSum(int userid, int[] cid){
            String sql = "select sum(prices) \n" +
                    "from product p join cart c on c.p_id=p.pno \n" +
                    "where userid=" + userid + " and ststus=0 and cid in (";
            String str = "";
            for (int i = 0; i < cid.length; i++) {
                sql += str + "" + cid[i] + "";
                if (i == cid.length - 1) {
                    sql += ")";
                    continue;
                }
                str = ",";
            }
            ResultSet rs = DBUtil.executeQuery(sql);
            BigDecimal c = null;
            try {
                if (rs.next()) {
                    c=rs.getBigDecimal(1);
                    return c;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    public List<CartJoinProduct> getCartId(int userid, int[] cid) {
        List<CartJoinProduct> cartList = new ArrayList<CartJoinProduct>();
        String sql = "select c.cid,p.prcture,p.pname,p.price,c.number,c.prices \n" +
                "from product p join cart c on c.p_id=p.pno \n" +
                "where userid=" + userid + " and ststus=0 and cid in (";
        String str = "";
        for (int i = 0; i < cid.length; i++) {
            sql += str + "" + cid[i] + "";
            if (i == cid.length - 1) {
                sql += ")";
                continue;
            }
            str = ",";
        }
        ResultSet rs = DBUtil.executeQuery(sql);
        CartJoinProduct c = null;
        try {
            while (rs.next()) {
                c = new CartJoinProduct(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBigDecimal(4),
                        rs.getInt(5),
                        rs.getBigDecimal(6));
                cartList.add(c);
            }
            return cartList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加购物车
    @Override
    public boolean getAdd(Cart cart) {
        String sql = "insert into cart(number,userid,prices,ststus,p_id) \n" +
                "values(?,?,?,?,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{cart.getNumber(), cart.getUserid(),
                cart.getPrices(),
                cart.getStstus(),
                cart.getP_id()
        });
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
    public boolean getUpdate(Cart cart, BigDecimal price) {
        String sql = "UPDATE cart set number=number+1, prices=prices+? \n" +
                "where cid=? and userid=? ";
        int i = DBUtil.executeUpdate(sql, new Object[]{price,
                cart.getCid(), cart.getUserid()});
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getUpdate2(Cart cart, BigDecimal price) {
        String sql = "UPDATE cart set number=?, prices=? \n" +
                "where cid=? and userid=? ";
        int i = DBUtil.executeUpdate(sql, new Object[]{cart.getNumber(),
                price, cart.getCid(), cart.getUserid()});
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getCount(int userid) {
        String sql = "select COUNT(*) from cart where userid=? and ststus=0";
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid});
        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public BigDecimal getSum(int userid) {
        String sql = "select sum(prices) from cart where userid=? and ststus=0";
        BigDecimal price = null;
        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{userid});
        try {
            if (rs.next()) {
                price = new BigDecimal(rs.getString(1));
                if(price!=null){
                    return price;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
