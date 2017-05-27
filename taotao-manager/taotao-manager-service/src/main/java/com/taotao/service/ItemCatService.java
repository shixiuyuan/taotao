package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by xy on 2017/5/22.
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
