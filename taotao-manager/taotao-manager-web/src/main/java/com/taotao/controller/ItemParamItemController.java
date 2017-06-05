package com.taotao.controller;

import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目名: taotao
 * 包名:  com.taotao.controller
 * 文件名: ItemParamItemController
 * 创建者:  xy
 * 创建时间: 2017/6/5 18:19
 * 描述 :
 */
@Controller
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping("/showitem/{itemId}")
    public String showItemParam(@PathVariable Long itemId,Model model){
        String string = itemParamItemService.getItemParamByItemId(itemId);
        //model增加一个string属性,string是itemParamItemService
        model.addAttribute("itemParam",string);
        return "item";
    }
}















