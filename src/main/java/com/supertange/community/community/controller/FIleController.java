package com.supertange.community.community.controller;

import com.supertange.community.community.dto.FileDTO;
import com.supertange.community.community.provider.UcloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 23:07 2020/1/17
 */
@Controller
public class FIleController {

    @Autowired
    private UcloudProvider ucloudProvider;

    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(HttpServletRequest request, MultipartFile MultipartFile) {
        try {
            MultipartFile.getInputStream();
            MultipartFile.getOriginalFilename();
            MultipartFile.getContentType();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setMessage("ok");
        fileDTO.setUrl("/static/img/a.jpg");
        return fileDTO;
    }

}
