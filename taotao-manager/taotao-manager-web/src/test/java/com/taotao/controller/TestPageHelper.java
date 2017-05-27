package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by xy on 2017/5/20.
 */
public class TestPageHelper {

    @Test
    public void testPageHelper(){

        //创建一个spring容器
        //从spring容器中获得Mapper的代理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-*.xml");
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);

        //分页处理
        PageHelper.startPage(1, 5);

        //执行查询，并分页
        TbItemExample example = new TbItemExample();
        List<TbItem> list = mapper.selectByExample(example);

        //取商品列表
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getTitle());
        }
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有商品："+ total);
        int pages = pageInfo.getPages();
        System.out.println("pages:" + pages);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize:" + pageSize);

    }

}
