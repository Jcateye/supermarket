package com.example.supermarket.controller;

import com.example.supermarket.mapper.UserMapper;
import com.example.supermarket.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/login")
    public ResponseEntity signIn(@RequestBody User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if(user1 == null) {
            throw new RuntimeException("用户不存在");
        }else{
            if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getPassword())) {
                throw new RuntimeException("账号或者密码不能为空");
            }

            if (user1.getUsername() != user.getUsername() || user1.getPassword() != user.getPassword() ){
                throw new RuntimeException("账号或者密码不正确");
            }
        }
        return ResponseEntity.ok("登录成功");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody@Validated User user){
        if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getPassword())) {
            throw new RuntimeException("账号或者密码不能为空");
        }
        user.setId(UUID.randomUUID().toString());

        try {
            userMapper.insert(user);
        } catch (Exception e) {
            throw new RuntimeException("注册失败" + e.getMessage());
        }

        return ResponseEntity.ok("测试成功!");
    }
}
