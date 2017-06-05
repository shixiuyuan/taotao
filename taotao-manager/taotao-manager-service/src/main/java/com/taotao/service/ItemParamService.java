package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by xy on 2017/6/1.
 */
public interface ItemParamService {

    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);
    //根据page,rows查询出itemParam出来
    EUDataGridResult getItemList(int page,int rows);
}
