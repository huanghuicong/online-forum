package com.web.onlineforumapi.service.impl;

import com.web.onlineforumapi.common.BusinessException;
import com.web.onlineforumapi.common.ResponseEnum;
import com.web.onlineforumapi.dao.SysUserDao;
import com.web.onlineforumapi.domain.SysUser;
import com.web.onlineforumapi.service.SysUserService;
import com.web.onlineforumapi.util.MD5Util;
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
    public List<SysUser> findUser() {
        List<SysUser> sysUserList = sysUserDao.findUserList();
        return sysUserList;
    }

    @Override
    public String login(SysUser sysUser) {
        SysUser user = sysUserDao.findUser(sysUser);
        String uuid = MD5Util.returnUuid();
        if (user == null) {
            throw new BusinessException("用户名密码错误", ResponseEnum.FAIL.getCode());
        } else {
            redisUtil.set(uuid, user.getId());
        }
        return uuid;
    }

    @Transactional
    public void testTran() {
        SysUser sysUser1 = new SysUser();
        sysUser1.setId(4L);
        sysUser1.setUserName("测试4");
        sysUser1.setPassword("aseqweqweqweqwe1");
        sysUserDao.insertUser(sysUser1);

        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUserName("测试");
        sysUser.setPassword("aseqweqweqweqwe");
        sysUserDao.insertUser(sysUser);
    }
}
