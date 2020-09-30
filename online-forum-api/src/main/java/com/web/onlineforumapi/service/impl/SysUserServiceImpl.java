package com.web.onlineforumapi.service.impl;

import com.web.onlineforumapi.dao.SysUserDao;
import com.web.onlineforumapi.domain.SysUser;
import com.web.onlineforumapi.service.SysUserService;
import com.web.onlineforumapi.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<SysUser> findUser () {
        List<SysUser> sysUserList = sysUserDao.findUserList();
        return sysUserList;
    }

}
