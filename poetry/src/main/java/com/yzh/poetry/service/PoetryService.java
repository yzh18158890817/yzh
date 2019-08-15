package com.yzh.poetry.service;

import com.yzh.common.Enum.YzhEnum;
import com.yzh.common.exception.YzhException;
import com.yzh.poetry.mapper.PoetryMapper;
import com.yzh.poetry.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yzh
 * @date 2019/8/15
 */
@Service
public class PoetryService {

    @Autowired
    private PoetryMapper poetryMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Boolean writePoetry(Poetry poetry) {
        Poetry p = new Poetry();
        p.setArticleName(poetry.getArticleName());
        Poetry one = this.poetryMapper.selectOne(p);
        if (one != null) {
            throw new YzhException(YzhEnum.COMMON_ERROR.build(1, "文章标题已存在"));
        }
        poetry.setCreated(new Date());
        poetry.setAuthor(redisTemplate.opsForValue().get("loginUserName"));
        int count = this.poetryMapper.insert(poetry);
        return count == 1;
    }

    public List<Poetry> getPoetryList() {
        Poetry p = new Poetry();
        p.setAuthor(redisTemplate.opsForValue().get("loginUserName"));
        List<Poetry> poetryList = this.poetryMapper.select(p);
        return poetryList;
    }
}
