package com.hejie.demo1st.service.impl;

import com.hejie.demo1st.entity.UserBean;
import com.hejie.demo1st.mapper.UserMapper;
import com.hejie.demo1st.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean findByName(String name) {
        // 查询用户是否存在
        UserBean bean = userMapper.findByName(name);
        if (bean != null) {
            // 查询用户信息、角色、权限
            bean = userMapper.findById(bean.getId());
        }
        return bean;
    }
}