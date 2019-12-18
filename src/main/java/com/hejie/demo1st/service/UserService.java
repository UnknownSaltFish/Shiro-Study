package com.hejie.demo1st.service;


import com.hejie.demo1st.entity.UserBean;

public interface UserService {

    UserBean findByName(String name);
}
