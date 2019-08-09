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
        User userOne = userMapper.selectOne(u);
        int count = 0;
        if (user.getUserName() != null) {
            if (userOne != null && user.getUserName().equals(userOne.getUserName())) {
//                throw new YzhException(YzhEnum.COMMON_ERROR.build(400, "用户已存在"));
                return false;
            }
            user.setId(null);
            Date date = new Date();
            user.setCreated(date);
            String birthYear = user.getBirthday().substring(0, 4);
            String dateStr = date.toString();
            user.setAge(Integer.parseInt(dateStr.substring(dateStr.length()-4)) - Integer.parseInt(birthYear));
            count = userMapper.insert(user);
        }
        return count == 1;
    }

    public User login(String userName, String password) {
        User u = new User();
        u.setUserName(userName);
        User selectOne = userMapper.selectOne(u);
        if (selectOne == null) {
            throw new YzhException(YzhEnum.USER_NOTEXIST);
        }
        if (selectOne.getPassword().equals(password)) {
            return selectOne;
        }
        if (selectOne != null && !selectOne.getPassword().equals(password)) {
            throw new YzhException(YzhEnum.PASSWORD_ERROR);
        }
        return null;
    }
}
