package com.lx.service;

import com.lx.POJO.User;
import com.lx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public boolean isHasName(String userName) {
        int count = userMapper.isHasName(userName);
        if(count == 0){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public User queryUserByUserNameAndPsw(String userName, String password) {
        User user = userMapper.queryUserByUserNameAndPsw(userName, password);
        return user;
    }

    @Override
    public String queryUserNameById(int id) {
        String name = userMapper.queryUserNameById(id);
        return name;
    }

    @Override
    public int queryIdByUserName(String userName) {
        int id = userMapper.queryIdByUserName(userName);
        return id;
    }
}
