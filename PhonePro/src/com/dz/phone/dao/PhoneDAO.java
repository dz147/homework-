package com.dz.phone.dao;

import com.dz.phone.entity.phone;

import java.util.List;

public interface PhoneDAO {
    List<phone> getPhones();
    phone getPhoneInfo(int id);
    boolean getDelete(int id);
    boolean getUpdate(phone ps);
    boolean getAdd(phone pInfo);
}
