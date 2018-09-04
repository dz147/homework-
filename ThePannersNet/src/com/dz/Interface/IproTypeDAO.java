package com.dz.Interface;

import com.dz.entity.proType;

import java.util.List;

public interface IproTypeDAO {
    List<proType> getProTypes();//查询产品类型结果集
    boolean getAdd(String name);//添加产品类型
    boolean getDelete(int pid);//删除类型产品
    boolean getUpdate(proType p);//更新
}
