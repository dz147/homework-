package com.dz.Interface;

import com.dz.entity.Cart;
import com.dz.entity.CartJoinProduct;

import java.math.BigDecimal;
import java.util.List;

public interface IcartDAO {
    List<CartJoinProduct> getCarts(int state, int userid);
    boolean getAdd(Cart cart);
    boolean getDelete(int id);
    boolean getUpdate(Cart cart, BigDecimal price);
    boolean getUpdate2(Cart cart, BigDecimal price);
    int getCount(int userid);
    BigDecimal getSum(int userid);
}
