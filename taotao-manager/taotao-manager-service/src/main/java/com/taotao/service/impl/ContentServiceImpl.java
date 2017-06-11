package com.taotao.service.impl;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service.impl
 * 文件名: ContentServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/10 22:31
 * 描述 :
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private TbContentMapper contentMapper;
    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全pojo
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //然后插入到数据库
        contentMapper.insert(content);
        return TaotaoResult.ok();
    }
}
