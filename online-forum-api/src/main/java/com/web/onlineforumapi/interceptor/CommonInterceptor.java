package com.web.onlineforumapi.interceptor;

import com.web.onlineforumapi.common.BusinessException;
import com.web.onlineforumapi.annotation.NoNeedLogin;
import com.web.onlineforumapi.common.ResponseEnum;
import com.web.onlineforumapi.dao.SysUserDao;
import com.web.onlineforumapi.domain.SysUser;
import com.web.onlineforumapi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Annotation annotation = ((HandlerMethod) handler).getMethodAnnotation(NoNeedLogin.class);
        if (annotation instanceof NoNeedLogin) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            throw new BusinessException("token为空", ResponseEnum.FAIL.getCode());
        } else {
            String userId = redisUtil.get(token, String.class);
            if (userId == null) {
                throw new BusinessException("凭证失效", ResponseEnum.FAIL.getCode());
            } else {
                SysUser sysUser = sysUserDao.findUserById(Long.parseLong(userId));
                if (sysUser == null) {
                    throw new BusinessException("用户信息获取失败", ResponseEnum.USERFAIL.getCode());
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("处理请求");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("请求结束");
    }
}
