package com.web.onlineforumapi.dao;


import com.web.onlineforumapi.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDao {
    public List<SysUser> findUserList();

    public SysUser findUserById(Long userId);

    public void insertUser(@Param("sysUser") SysUser sysUser);
}
