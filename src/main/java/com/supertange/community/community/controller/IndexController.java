package com.supertange.community.community.controller;

import com.supertange.community.community.dto.QuestionDTO;
import com.supertange.community.community.mapper.QuestionMapper;
import com.supertange.community.community.mapper.UserMapper;
import com.supertange.community.community.model.Question;
import com.supertange.community.community.model.User;
import com.supertange.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "index";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String value = cookie.getValue();
                User user = userMapper.findByToken(value);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        List<QuestionDTO> questionDTOList = questionService.list();

        model.addAttribute("questionList", questionDTOList);
        return "index";
    }


}
