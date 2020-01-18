package com.supertange.community.community.controller;

import com.supertange.community.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 23:07 2020/1/17
 */
@Controller
public class FIleController {


    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload() {

        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setMessage("ok");
        fileDTO.setUrl("/static/img/a.jpg");
        return fileDTO;
    }

}
