package com.supertange.community.community.interceptor;

import com.supertange.community.community.mapper.UserMapper;
import com.supertange.community.community.model.User;
import com.supertange.community.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return true;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String value = cookie.getValue();
                UserExample userExample = new UserExample();
                userExample.createCriteria()
                        .andTokenEqualTo(value);
                List<User> userList = userMapper.selectByExample(userExample);
                if (userList.size() != 0) {
                    request.getSession().setAttribute("user", userList.get(0));
                }
                break;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
