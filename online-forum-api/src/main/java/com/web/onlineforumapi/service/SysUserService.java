package com.web.onlineforumapi.service;

import com.web.onlineforumapi.domain.SysUser;

import java.util.List;

public interface SysUserService {

    public List<SysUser> findUser();

    public String login(SysUser sysUser);
}
