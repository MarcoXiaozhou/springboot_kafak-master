package com.baoshan.shanghai.project.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baoshan.shanghai.project.entity.User;
import com.baoshan.shanghai.project.mapper.UserMapper;
import com.baoshan.shanghai.project.service.IUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
