package com.taotao.service;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service
 * 文件名: ItemParamItemServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/4 17:53
 * 描述 :接收商品id查询规格参数表。根据返回的规格参数生成html返回html。
 */

public interface  ItemParamItemService {
    String getItemParamByItemId(Long itemID);
}
