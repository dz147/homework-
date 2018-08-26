package com.nf.bookstore1.session;

public interface MySession {
    String id();
    Object get(String key);
    void set(String key, Object value);
}
