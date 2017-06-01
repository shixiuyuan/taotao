package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by xy on 2017/5/20.
 */
public interface ItemService {

    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem item,String desc) throws Exception;
}
