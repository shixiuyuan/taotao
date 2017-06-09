package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名: taotao
 * 包名:  com.taotao.portal.controller
 * 文件名: IndexController
 * 创建者:  xy
 * 创建时间: 2017/6/6 18:04
 * 描述 :
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }

}
