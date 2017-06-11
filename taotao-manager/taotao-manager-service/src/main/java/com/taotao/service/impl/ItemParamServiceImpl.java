package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service.impl
 * 文件名: ItemParamServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/1 19:27
 * 描述 : 商品规格参数模板
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private TbItemParamMapper itemParamMapper;


    @Override
    public TaotaoResult getItemParamByCid(long cid) {

        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        //selectByExample和selectByExampleWithBLOBs的区别是少了一个param_data(里面是json数据)
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //判断是否查询到结果
        if(list!=null && list.size()>0){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {
        //把json数据插入到数据库,补全pojo
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParam.getItemCatId();
        //插入到规格参数模板表
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemParamExample example = new TbItemParamExample();
        //分页处理
        PageHelper.startPage(page,rows);
        //List<TbItemParam> list = itemParamMapper.selectByExample(example);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
        result.setTotal(pageInfo.getTotal());

        return result;


    }
}























