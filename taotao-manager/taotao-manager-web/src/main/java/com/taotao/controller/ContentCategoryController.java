package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.controller
 * 文件名: ContentCategoryController
 * 创建者:  xy
 * 创建时间: 2017/6/9 22:48
 * 描述 : 接受页面传递过来的parentId,根据parentId查询节点列表节点列表,返回List<EUTreeNode>,需要相应json数据
 */
@Controller
@RequestMapping("/content")
public class ContentCategoryController {

    //注入service
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/category/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue = "0") Long parentId){
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }

    @RequestMapping("/category/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId,String name){
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId,name);
        return result;
    }

    @RequestMapping("/category/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(long id){
        TaotaoResult result = contentCategoryService.deleteContentCategory(id);
        return result;
    }

    @RequestMapping("/category/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(long id,String name){
        TaotaoResult result =contentCategoryService.updateContentCategory(id,name);
        return result;
    }

    @RequestMapping("/query/list")
    @ResponseBody
    public EUDataGridResult getContent(long categoryId){
        EUDataGridResult result = contentCategoryService.getContent(categoryId);
        return result;
    }
}
