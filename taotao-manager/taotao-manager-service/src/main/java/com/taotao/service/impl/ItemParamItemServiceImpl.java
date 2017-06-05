package com.taotao.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.taotao.common.utils.JsonUtils.jsonToList;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service.impl
 * 文件名: ItemParamItemServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/4 17:57
 * 描述 : 接收商品id查询规格参数表。根据返回的规格参数生成html返回html。
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService{

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public String getItemParamByItemId(Long itemId) {
        //生成一个规格参数表的例子
        TbItemParamItemExample example = new TbItemParamItemExample();
        //用例子创建一个标准
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        //标准是什么
        criteria.andItemIdEqualTo(itemId);
        //执行查询
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if(list == null || list.size() == 0){
            return "";
        }
        //取规格参数
        TbItemParamItem itemParamItem = list.get(0);
        String paramData = itemParamItem.getParamData();

        //生成html
        //把规格参数json数据转换成java对象
        List<Map> jsonList = JsonUtils.jsonToList(paramData,Map.class);
        StringBuffer sb = new StringBuffer();
        for(Map m1:jsonList) {
            sb.append("<div class=\"Ptable-item\">\n");
            sb.append("            <h3>"+m1.get("group")+"</h3>\n");
            List<Map> list2 = (List<Map>)m1.get("params");
            for(Map m2:list2) {
                sb.append("            <dl>\n");
                sb.append("                                          <dt>"+m2.get("k")+"</dt><dd>"+m2.get("v")+"</dd>\n");
                sb.append("                                      </dl>\n");
            }
            sb.append("          </div>");
        }
        return sb.toString();
    }
}















