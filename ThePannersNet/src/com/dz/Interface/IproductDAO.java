package com.dz.Interface;

import com.dz.entity.Product;

import java.util.List;

public interface IproductDAO {
    List<Product> getProducts(int state);//查询状态为上架的产品
    List<Product> getProducts(int state ,String name);//查询状态为上架且可通过模糊查询
    List<Product> getProducts(int state ,int ptid);//查询状态为上架且类型相对应的数据
    boolean getAdd(Product product);//添加产品方法
    boolean getDelete(int id);//删除产品方法
    boolean getUpdate(Product product);//修改产品方法
}
