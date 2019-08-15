package com.yzh.poetry.controller;

import com.yzh.poetry.pojo.Poetry;
import com.yzh.poetry.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yzh
 * @date 2019/8/15
 */
@RestController
@CrossOrigin
@RequestMapping("/poetry")
public class PoetryController {

    @Autowired
    private PoetryService poetryService;

    /**
     * 写作
     * @param poetry
     * @return
     */
    @RequestMapping(value = "/writePoetry", method = RequestMethod.POST)
    public ResponseEntity<Boolean> writePoetry(@RequestBody Poetry poetry) {
        return ResponseEntity.ok(this.poetryService.writePoetry(poetry));
    }

    /**
     * 根据登录用户信息查询所有作品
     * @return
     */
    @RequestMapping(value = "/getPoetryList", method = RequestMethod.GET)
    public ResponseEntity<List<Poetry>> getPoetryList() {
        return ResponseEntity.ok(this.poetryService.getPoetryList());
    }
}
