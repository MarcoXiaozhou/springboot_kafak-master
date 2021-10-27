package com.baoshan.shanghai.project.controller;

import java.util.List;
import java.util.UUID;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baoshan.shanghai.project.entity.User;
import com.baoshan.shanghai.project.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/list")
    public List<User> getUserList() {
        List<User> list = userService.list();
        return list;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean save(@RequestBody User user) {
        Snowflake snowflake =IdUtil.createSnowflake(1,1);
        long id = snowflake.nextId();
        user.setId(id);
        boolean flag = userService.save(user);
        return flag;
    }
}
