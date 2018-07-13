package com.xlh.crm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.dto.RespRestfulDto;
import com.xlh.crm.service.impl.ActivityServiceImpl;
import com.xlh.crm.utils.RespCommon;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(FileController.class.getName());

    @Value("${file.image.uploadPath}")
    private String imagePath;
    @Value("${file.enterprise.path}")
    private String enterpriseUploadPath;
    @Autowired
    private ActivityServiceImpl activityService;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    @RequestMapping("/uploadImage")
    public String uploads(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (file.isEmpty()) {
            return "";
        }

        int size = (int) file.getSize();

        if (size <= 0) {
            return "";
        }
        String orangeName=file.getOriginalFilename();
        int dotIndex = orangeName.lastIndexOf(".");
        if (dotIndex < 0) {
            throw new Exception("文件格式不正确");
        }
        String end = orangeName.substring(dotIndex+1, orangeName.length()).toLowerCase();
        String fileName=System.currentTimeMillis()+"."+end;
        File dest = new File(imagePath + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest); //保存文件
            return fileName;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return "";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }


    }

    @RequestMapping("/uploadActivityExcel")
    public RespRestfulDto uploadActivityExcel(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        try{
            if (file.isEmpty()) {
                throw new Exception("文件为空");
            }
            String orangeName=file.getOriginalFilename();
            int dotIndex = orangeName.lastIndexOf(".");
            if (dotIndex < 0) {
                throw new Exception("文件格式不正确");
            }
            String end = orangeName.substring(dotIndex+1, orangeName.length()).toLowerCase();
            String fileName=System.currentTimeMillis()+"."+end;
            File dest = new File(imagePath + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest); //保存文件
            return RespCommon.success(activityService.dealExcel(dest));
        }catch (Exception e){
            return RespCommon.fail(e);
        }
    }

    @RequestMapping(value = "/uploadEnterpriseFile", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String file_name=simpleDateFormat.format(new Date())+"."+getExtensionName(file.getOriginalFilename());
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(enterpriseUploadPath+file_name)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return file_name;
        } else {
            return "上传失败，因为文件是空的.";
        }
    }
    @RequestMapping("downloadEnterpriseFile")
    public void doGet(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName") String fileName)
            throws ServletException, IOException {
        //得到要下载的文件名
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        //通过文件名找出文件的所在目录
        //得到要下载的文件
        File file = new File(enterpriseUploadPath + fileName);

        //如果文件不存在
        if (!file.exists()) {
            LOGGER.info(enterpriseUploadPath + fileName+"文件不存在");
        }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_") + 1);
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(enterpriseUploadPath + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }
    public String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
}
