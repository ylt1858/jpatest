package com.studuyjpa.controller.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ylt
 * @date 2021/4/18 15:53
 */
@Controller
public class FileController {
    public static void main(String[] args) {
        System.err.println(System.getProperty("user.dir"));
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        //String UPLOAD_DIR = "/Users/itinypocket/workspace/temp/"; D:\BaiduNetdiskDownload\jpa
        String UPLOAD_DIR = System.getProperty("user.dir") + "\\upload\\";
        File dest = new File(UPLOAD_DIR + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }
}
