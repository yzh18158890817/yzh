package com.yzh.controller;

import com.yzh.common.Enum.YzhEnum;
import com.yzh.common.exception.YzhException;
import com.yzh.pojo.User;
import com.yzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @author yzh
 * @date 2019/8/8
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user, BindingResult result) {
        if (result.hasFieldErrors()) {
            String msg = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining("|"));
            //抛出异常
            throw new YzhException(YzhEnum.COMMON_ERROR.build(400, msg));
        }
        Boolean flag = userService.register(user);
        String data = flag ? "注册成功" : "注册失败";
        return ResponseEntity.ok(data);
    }


}
