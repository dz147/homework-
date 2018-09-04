package com.dz.entity;

import com.dz.dao.*;

import java.math.BigDecimal;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserDAO dao=new UserDAO();
        proTypeDAO dao1=new proTypeDAO();
        ProductDAO dao2=new ProductDAO();
        CartDAO dao3=new CartDAO();
        positionDAO dao4=new positionDAO();
        String name="lgj";String pwd="123321";
        Users userInfo = dao.getUserInfo(name, pwd);
        System.out.println(userInfo);
        /*Users users = new Users("lgj","123321","12345678901","8574837@qq.com");
        boolean add = dao.getAdd(users);
        if(add){
            System.out.println(add);
        }*/
       /* boolean add = dao2.getAdd(new Product("Apple 苹果 iPhone8 Plus 手机 深空灰色 全网通 64GB",
                1, new BigDecimal(5438.00), "64G", 0, "pic8p"));*/
        Product price = dao2.getPrice(0, 1);
        System.out.println("单个商品价格："+price.getPrice());
        List<Product> products = dao2.getProducts(0, 1);
        for (Product p:products) {
            System.out.println(p);
        }
        List<proType> proTypes = dao1.getProTypes();
        for (proType p:proTypes) {
            System.out.println(p);
        }
        BigDecimal sum = dao3.getSum(4);
        System.out.println(sum);
        List<CartJoinProduct> cartId = dao3.getCartId(4, new int[]{24, 25});
        System.out.println(cartId);
        List<Positions> ps = dao4.getPositions(1);
        for (Positions p:ps) {
            System.out.println(p);
        }
        System.out.println("总额");
        BigDecimal bigDecimal = dao3.CartSum(4, new int[]{25, 26});
        System.out.println(bigDecimal);
        System.out.println("以下是商品分页");
        List<Product> productInfo = dao2.getProductInfo((1 - 1), 3);
        for (Product p:productInfo) {
            System.out.println(p);
        }
    }

}
