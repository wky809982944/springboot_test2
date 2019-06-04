package com.wangkaiyi.service;

import com.wangkaiyi.mapper.UserMapper;
import com.wangkaiyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;


    public Long register(String username, String password) {
    /*    User user = new User();
        user.setUsername(username);
        List<User> list = userMapper.select(user);
        if (!CollectionUtils.isEmpty(list)) {
            //throw new Exception(ExceptionEnum.REGISTER_ERROR);
        }*/
        User user = new User();
        Long userId;
        Long status = new Long((long)0);
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(status);

        userMapper.insertSelective(user);
        Example e = new Example(User.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("username", username);
        List<User> list = userMapper.selectByExample(e);
        userId = list.get(0).getId();
        return userId;
    }

    public List<User> queryAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    public void saveAll(String username, String password, String gender) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        userMapper.insert(user);
    }

    public User queryById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void updateById(Long id, String username, String password, String gender) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        int count = userMapper.updateByPrimaryKeySelective(user);
    }

    public void insert(String username, String password, String gender) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        userMapper.insertSelective(user);
    }

    public boolean check(String username, String password) {
        Example e = new Example(User.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("username", username);
        c.andEqualTo("password", password);
        List<User> list = userMapper.selectByExample(e);
        if (!CollectionUtils.isEmpty(list)) {
            return true;
        } else {
            return false;
        }
    }

    public User queryByName(String username) {
        Example e = new Example(User.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("username",username);
        List<User> list = userMapper.selectByExample(e);
        return list.get(0);
    }

    public void updateAddress(Long id, String address) {
        User user = new User();
        user.setId(id);
        user.setAddress(address);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updateGender(String userGender,Long id) {
        User user = new User();
        user.setId(id);
        user.setGender(userGender);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void updatePassword(Long userId, String userConfirmPassword) {
        User user = new User();
        user.setId(userId);
        user.setPassword(userConfirmPassword);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void activation(Long id) {
        Long status = new Long((long)1);
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
