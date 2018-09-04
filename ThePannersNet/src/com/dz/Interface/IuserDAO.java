package com.dz.Interface;

import com.dz.entity.Users;

public interface IuserDAO {
    Users getUserInfo(String name ,String pwd);
    boolean getAdd(Users user);
}
