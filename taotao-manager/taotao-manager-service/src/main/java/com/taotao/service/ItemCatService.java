package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by xy on 2017/5/22.
 */
public interface ItemCatService {
    List<EUTreeNode> getItemCatList(long parentId);
}
