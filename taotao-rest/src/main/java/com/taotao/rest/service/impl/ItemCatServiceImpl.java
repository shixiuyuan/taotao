package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.rest.service.impl
 * 文件名: ItemCatServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/6 22:44
 * 描述 :
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public CatResult getItemCatList() {
        //要得到这样的数据结构怎么查.
        //返回一个catResult给他吧。。
        CatResult catResult = new CatResult();
        catResult.setData(getCatList((long)0));
        return catResult;
    }

    private List<?> getCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);

        //返回值resultList
        List resultList = new ArrayList<>();

        int count = 0;
        //向resultList中添加节点
        //把list里面的数据遍历出来存到resultList中
        for(TbItemCat itemCat : list){
            CatNode catNode = new CatNode();
            //判断是否为父节点
            if(itemCat.getIsParent()){
                if(parentId == 0){
                    catNode.setName( "<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
                }else{
                    catNode.setName(itemCat.getName());
                }
                catNode.setUrl("/products/"+itemCat.getId()+".html");
                catNode.setItem(getCatList(itemCat.getId()));

                resultList.add(catNode);
                if(parentId == 0){
                    count++;
                    if(count>=14){
                        break;
                    }
                }
                //如果是叶子节点
            }else{
                resultList.add("/products/"+itemCat.getId()+".html|"+itemCat.getName());
            }
        }
        return resultList;
    }
}













