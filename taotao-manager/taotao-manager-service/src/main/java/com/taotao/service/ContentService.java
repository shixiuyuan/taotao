package com.taotao.service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service
 * 文件名: ContentService
 * 创建者:  xy
 * 创建时间: 2017/6/10 22:31
 * 描述 : 内容管理,新增-->提交-->插入数据库
 */

public interface ContentService {
    TaotaoResult insertContent(TbContent content);
}
