package com.highkgao.voteweb.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "upload")
public class UploadController {

    @RequestMapping(value = "itemImage.upload",method = RequestMethod.POST)
    public ModelAndView itemImageUpload(@RequestParam(value = "file" ,required = false)MultipartFile file,HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        return null;
    }

}
