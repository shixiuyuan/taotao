package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目名: taotao
 * 包名:  com.taotao.service.impl
 * 文件名: ContentCategoryServiceImpl
 * 创建者:  xy
 * 创建时间: 2017/6/9 22:28
 * 描述 :
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Autowired
    private TbContentMapper contentMapper;

    /*
     * 得到分类列表
     */
    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        //首先创建一个例子
        TbContentCategoryExample example = new TbContentCategoryExample();
        //用例子来创建一个标准
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        //把标准的条件写好
        criteria.andParentIdEqualTo(parentId);
        //执行查询得到内容目录列表
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        //创建一个集合来接受list里面的内容
        List<EUTreeNode> resultList = new ArrayList<>();
        //遍历列表
        for(TbContentCategory contentCategory : list){
            EUTreeNode node = new EUTreeNode();
            node.setId(contentCategory.getId());
            node.setState(contentCategory.getIsParent()?"closed":"open");//如果是父节点就关闭,是子节点就打开
            node.setText(contentCategory.getName());

            resultList.add(node);
        }
        return resultList;
    }

    /*
       把添加的节点插入到数据库
     */
    @Override
    public TaotaoResult insertContentCategory(long parentId, String name) {
        //创建一个pojo
        TbContentCategory contentCategory = new TbContentCategory();
        //把东西set进去吧.
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setIsParent(false);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //东西set完了,因为id是自增长的,所以在mapper那里配置了
        //把新添加的节点数据插入到数据库
        contentCategoryMapper.insert(contentCategory);
        //查看父节点的isParent是否为true,如果不是true改true
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断是否为true
        if(!parentCat.getIsParent()){
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        return TaotaoResult.ok(contentCategory);
    }

    /*
      这个服务是用来删除节点的...
     */
    @Override
    public TaotaoResult deleteContentCategory(long id) {

        //先用id把node实体搞出来 , 并得到他的parentId..
        TbContentCategory node = contentCategoryMapper.selectByPrimaryKey(id);
        long parentId = node.getParentId();
        TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);

        //把和parentId相等的子节点全部拿出来
        TbContentCategoryExample example2 = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example2);

       //删除你选中的子节点
        contentCategoryMapper.deleteByPrimaryKey(id);
        //遍历list看是否还有子节点
        for(TbContentCategory contentCategory : list){
            long nodeParentId = contentCategory.getParentId();
           if(nodeParentId == parentId){
               parentNode.setIsParent(true);
               break;
           }else{
               parentNode.setIsParent(false);
           }
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContentCategory(long id, String name) {
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        contentCategory.setName(name);
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
        return TaotaoResult.ok();
    }

    @Override
    public EUDataGridResult getContent(long categoryId) {

        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(1,10);
        List<TbContent> list = contentMapper.selectByExample(example);
        //创建一个返回对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //去记录总条数
        PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }
}
