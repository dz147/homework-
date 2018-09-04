package com.dz.Interface;

import com.dz.entity.OrderFrom;

import java.util.List;

public interface IorderfromDAO {
    List<OrderFrom> getOrderFroms();
    boolean getAdd(OrderFrom orderfrom);
}
