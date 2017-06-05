package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.controller
 * 文件名: TestPageHelper2
 * 创建者:  xy
 * 创建时间: 2017/6/5 21:31
 * 描述 :
 */

public class TestPageHelper2 {

    @Test
    public void testPageHelper(){

        //创建一个spring容器
        //从spring容器中获得Mapper的代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-*.xml");
        TbItemParamMapper mapper = applicationContext.getBean(TbItemParamMapper.class);

        //分页处理
        PageHelper.startPage(1, 5);

        //执行查询，并分页
//        TbItemExample example = new TbItemExample();
//        List<TbItem> list = mapper.selectByExample(example);

        //执行查询,并分页
        TbItemParamExample example = new TbItemParamExample();
        List<TbItemParam> list = mapper.selectByExampleWithBLOBs(example);

        //取商品列表
        for (TbItemParam itemParam : list) {
            System.out.print(itemParam.getId());
            System.out.print(itemParam.getParamData());
            System.out.println();
        }
        //取分页信息
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有商品："+ total);
        int pages = pageInfo.getPages();
        System.out.println("pages:" + pages);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize:" + pageSize);

    }
}
