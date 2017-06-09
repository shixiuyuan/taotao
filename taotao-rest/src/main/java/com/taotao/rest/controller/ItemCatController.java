package com.taotao.rest.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目名: taotao
 * 包名:  com.taotao.rest.controller
 * 文件名: ItemCatController
 * 创建者:  xy
 * 创建时间: 2017/6/7 12:41
 * 描述 : 商品分类列表
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
//
//    @RequestMapping(value= "/itemCat/list",
//            produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//    @ResponseBody
//    public String getItemCatList(String callback){
//        //返回来的是一个pojo对象,要转成字符串
//        CatResult catResult = itemCatService.getItemCatList();
//        //把catResult转换成一个json
//        String json = JsonUtils.objectToJson(catResult);
//        //拼装返回值
//        String result = callback+"("+json+");";
//        return result;
//    }
    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback){
        CatResult catResult = itemCatService.getItemCatList();
        //srpingmvc4.1
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
