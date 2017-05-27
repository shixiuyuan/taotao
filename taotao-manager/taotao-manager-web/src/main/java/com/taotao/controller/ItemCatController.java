package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import com.taotao.service.impl.ItemCatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 得到商品分类管理Controller
 * Created by xy on 2017/5/22.
 */
@Controller
@RequestMapping("/item/cat/")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId){
        List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }
}
