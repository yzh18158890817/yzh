package com.yzh.service;

import com.yzh.common.Enum.YzhEnum;
import com.yzh.common.exception.YzhException;
import com.yzh.mapper.UserMapper;
import com.yzh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author yzh
 * @date 2019/8/8
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean register(User user) {
        User u = new User();
        u.setUserName(user.getUserName());
        System.out.println(user.getUserName());
        User userOne = userMapper.selectOne(u);
        int count = 0;
        if (user.getUserName() != null) {
            if (userOne != null && user.getUserName().equals(userOne.getUserName())) {
//                throw new YzhException(YzhEnum.COMMON_ERROR.build(400, "用户已存在"));
                return false;
            }
            user.setId(null);
            user.setCreated(new Date());
            count = userMapper.insert(user);
        }
        return count == 1;
    }
}
