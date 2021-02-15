package com.web.onlineforumapi.demo;

import com.web.onlineforumapi.domain.SysUser;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class RecursionDemo {
    public static void main(String[] args) {
        List<SysUser> sysUserList = new ArrayList<SysUser>();
        SysUser sysUser1 = new SysUser();
        sysUser1.setId(1L);
        sysUser1.setUserName("111");

        SysUser sysUser2 = new SysUser();
        sysUser2.setId(2L);
        sysUser2.setUserName("222");
        sysUser2.setParentId(1L);

        SysUser sysUser3 = new SysUser();
        sysUser3.setId(3L);
        sysUser3.setUserName("222");
        sysUser3.setParentId(2L);

        SysUser sysUser4 = new SysUser();
        sysUser4.setId(4L);
        sysUser4.setUserName("111");

        SysUser sysUser5 = new SysUser();
        sysUser5.setId(5L);
        sysUser5.setUserName("222");
        sysUser5.setParentId(2L);

        SysUser sysUser6 = new SysUser();
        sysUser6.setId(6L);
        sysUser6.setUserName("222");
        sysUser6.setParentId(5L);

        sysUserList.add(sysUser1);
        sysUserList.add(sysUser2);
        sysUserList.add(sysUser3);
        sysUserList.add(sysUser4);
        sysUserList.add(sysUser5);
        sysUserList.add(sysUser6);

        System.out.println(sysUserList);
        System.out.println();
     }

     public void sysUsers(List<SysUser> sysUserList) {
         SysUser sysUser1 = new SysUser();
         sysUser1.setId(1L);
         sysUser1.setUserName("111");

         SysUser sysUser4 = new SysUser();
         sysUser4.setId(4L);
         sysUser4.setUserName("111");

         for (int i = 0; i < sysUserList.size(); i++) {

        }
     }
}
