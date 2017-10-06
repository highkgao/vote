package com.highkgao.voteweb.business.controller;

import com.highkgao.voteweb.contants.WebContants;
import com.highkgao.voteweb.util.GenerateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping(value = "upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);


    @RequestMapping(value = "itemImageAsync.upload", method = RequestMethod.POST)
    public ModelAndView itemImageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String webRootPath = request.getSession().getServletContext().getRealPath("");
        String webRootPathArray[] = webRootPath.split("/");
        StringBuilder imageBuilder = new StringBuilder();
        // 和tomcat同一层增加目录
        for (int i = 0; i < webRootPathArray.length - 3; i++) {
            imageBuilder.append(webRootPathArray[i]);
            imageBuilder.append('/');
        }

        imageBuilder.append("/userImages/");
        String imagePath = imageBuilder.toString();
        String origianlName = file.getOriginalFilename();

        String suffix = StringUtils.substring(origianlName, origianlName.lastIndexOf('.')).toLowerCase();

        String fileName = GenerateUtil.generateUniqueId() + suffix;

        File imageDir = new File(imagePath);
        if (!imageDir.exists()) {
            synchronized (this) {
                if (!imageDir.exists()) {
                    imageDir.mkdirs();
                }
            }
        }

        File targetFile = new File(imagePath, fileName);

        try {
            file.transferTo(targetFile); //传送  失败就抛异常
        } catch (Exception e) {
            LOGGER.error("上传文件失败", e);
            throw new RuntimeException(e);
        }
        ModelAndView modelAndView = new ModelAndView(new MappingJacksonJsonView());
        modelAndView.addObject(WebContants.DATA, fileName);
        modelAndView.addObject(WebContants.STATUS, WebContants.STATUS_SUCCESS);
        return modelAndView;
    }

}
