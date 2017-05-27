package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by xy on 2017/5/25.
 */
public class FTPTest {

    @Test
    public void testFtpClient() throws Exception{
        //创建一个FtpClient对象..
        FTPClient ftpClient = new FTPClient();
        //创建ftp连接.默认是21端口
        ftpClient.connect("192.168.25.133",21);
        //登录ftp服务器,使用用户名和密码
        ftpClient.login("ftpuser","ftpuser");
        //上传文件.
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\xy\\Desktop\\2.jpg"));
        //设置上传的路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/2017");
        //修改上传未见的格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数:服务器端文档名
        //第二个参数:上传文档的inputStream
        ftpClient.storeFile("hello2.jpg",inputStream);
        //关闭连接
        ftpClient.logout();
    }

    @Test
    public void testFtpUtil() throws Exception{
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\xy\\Desktop\\2.jpg"));
        FtpUtil.uploadFile("192.168.25.133",21,"ftpuser",
                "ftpuser","/home/ftpuser/www/images","/2017/5/26","hello.jpg",inputStream);
    }
}







