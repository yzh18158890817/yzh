package com.yzh.service;

import com.yzh.common.Enum.YzhEnum;
import com.yzh.common.exception.YzhException;
import com.yzh.mapper.UserMapper;
import com.yzh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yzh
 * @date 2019/8/8
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

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
            redisTemplate.opsForValue().set("loginUserName",userName,30, TimeUnit.MINUTES);
            return selectOne;
        }
        if (selectOne != null && !selectOne.getPassword().equals(password)) {
            throw new YzhException(YzhEnum.PASSWORD_ERROR);
        }
        return null;
    }
}
