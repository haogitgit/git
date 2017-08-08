package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<TreeNode> getItemCatList(long parentId) {
		List<TreeNode> tree = new ArrayList<>();
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			TreeNode treeNode = new TreeNode(tbItemCat.getId(),
					tbItemCat.getName(),
					tbItemCat.getIsParent()?"closed":"open");
			tree.add(treeNode);
		}
		return tree;
	}
	

}
