package com.example.supermarket.controller;

import com.example.supermarket.mapper.UserMapper;
import com.example.supermarket.pojo.User;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/login")
    public ResponseEntity signIn(@RequestBody User user) {
        User user1 = userMapper.selectByName(user.getUsername());
        if(user1 == null) {
            return new ResponseEntity("用户不存在", HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getPassword())) {
                return new ResponseEntity("账号或者密码不能为空",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (!user1.getUsername().equals(user.getUsername())  || !user1.getPassword().equals(user.getPassword()) ){
                return new  ResponseEntity("账号或者密码不正确", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return ResponseEntity.ok("登录成功");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody@Validated User user){
        if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getPassword())) {
            return new ResponseEntity("账号或者密码不能为空",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        user.setId(UUID.randomUUID().toString().replace("-", ""));

        try {
            if(userMapper.selectByName(user.getUsername()) != null) {
                return new ResponseEntity("用户名已存在",HttpStatus.INTERNAL_SERVER_ERROR );
            }
            userMapper.insert(user);
        } catch (Exception e) {
            return new ResponseEntity( "注册失败" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("注册成功!");
    }
}
