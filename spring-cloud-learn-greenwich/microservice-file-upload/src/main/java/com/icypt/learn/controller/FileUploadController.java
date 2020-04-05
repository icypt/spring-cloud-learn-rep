package com.icypt.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/13 22:44
 * version：1.0
 * description：
 */
@Controller
public class FileUploadController {

    @PostMapping("fileUpload")
    public String fileUpload(MultipartFile file, Model model) throws Exception{
        byte[] fileByte = file.getBytes();


        File storeFile = new File(file.getOriginalFilename());

        FileCopyUtils.copy(fileByte, storeFile);

        model.addAttribute("storePath", storeFile.getAbsolutePath());
        return "fileUpload";
    }

    @GetMapping("goFileUploadPage")
    public String goFileUploadPage() {
        return "fileUpload";
    }
}
