package com.hejie.demo1st.mapper;


import com.hejie.demo1st.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserBean findByName(String name);

    UserBean findById(String id);
}