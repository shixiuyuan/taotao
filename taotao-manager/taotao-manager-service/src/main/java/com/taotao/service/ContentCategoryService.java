package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;

import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service
 * 文件名: ContentCategoryService
 * 创建者:  xy
 * 创建时间: 2017/6/9 22:25
 * 描述 : 后台页面的网站内容管理
 */

public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCategory(long parentId,String name);//节点的名称
    TaotaoResult deleteContentCategory(long id);
    //根据id更新名字
    TaotaoResult updateContentCategory(long id,String name);
    //显示内容管理的内容
    EUDataGridResult getContent(long categoryId);
}
