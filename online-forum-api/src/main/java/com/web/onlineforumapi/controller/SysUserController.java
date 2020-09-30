package com.web.onlineforumapi.controller;

import com.web.onlineforumapi.annotation.NoNeedLogin;
import com.web.onlineforumapi.common.ResultData;
import com.web.onlineforumapi.domain.SysUser;
import com.web.onlineforumapi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @NoNeedLogin
    @GetMapping(value = "/findUser")
    public ResultData getElectricityMonthReport() {
        List<SysUser> userList = sysUserService.findUser();
        return ResultData.success(userList);
    }
}
