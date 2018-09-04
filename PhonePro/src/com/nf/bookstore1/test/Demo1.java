package com.nf.bookstore1.test;

import com.dz.phone.entity.phone;
import com.dz.dao.PhoneIMDAO;
import util.DBUtil;
import util.DBUtil2;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        getSQLite();
        //getPhoneInfo();
    }

    public static void getPhoneInfo() {
               /* System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getBigDecimal(3)
                        +"  "+res.getDate(4)+"  "+res.getInt(5)+"  "+res.getInt(6)
                        +"  "+res.getInt(7)+"  "+res.getString(8));*/
        PhoneIMDAO phones=new PhoneIMDAO();
        //boolean resule=phones.getAdd(new phone("iPhone XS",new BigDecimal(9999.88) ,DBUtil.date("2018-09-21"),23000,11895,1,"picxs"));
        boolean result = phones.getDelete(11);
        if(result){
            System.out.println("添加成功！");
        }
        List<phone> pInfo= phones.getPhones();
            for (phone ps:pInfo) {
                System.out.println(ps);
            }

    }
    public static void getSQLite() throws SQLException {
        ResultSet resultSet = DBUtil2.executeQuery("select * from product");
            while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"\n"+resultSet.getString(2));
        }
    }
}
