package com.web.onlineforumapi.controller;

import com.web.onlineforumapi.annotation.NoNeedLogin;
import com.web.onlineforumapi.common.ResultData;
import com.web.onlineforumapi.domain.SysUser;
import com.web.onlineforumapi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findUser")
    public ResultData findUser() {
        List<SysUser> userList = sysUserService.findUser();
        return ResultData.success(userList);
    }

    @PostMapping(value = "/login")
    public ResultData login(@RequestBody SysUser sysUser) {
        String uuid = sysUserService.login(sysUser);
        return ResultData.success(uuid);
    }
}
