package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
		public List<TreeNode> getCategoryList(long parentId) {
		List<TreeNode> result = new ArrayList<>();
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catgoryList = tbContentCategoryMapper.selectByExample(example);
		for (TbContentCategory tbContentCategory : catgoryList) {
			long id = tbContentCategory.getId();
			String text = tbContentCategory.getName();
			String state = tbContentCategory.getIsParent()?"closed":"open";
			TreeNode node = new TreeNode(id, text, state);
			result.add(node);
		}
		return result;
	}

	
	public TaotaoResult insertContentCategory(long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setStatus(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		tbContentCategoryMapper.insert(contentCategory);
		//
		TbContentCategory parentCat = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent())
		{
			parentCat.setIsParent(true);
			tbContentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(contentCategory);
		
	}


	public TaotaoResult deleteContentCategory(long id) {
		TbContentCategory contentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
		long parentId = contentCategory.getParentId();
		tbContentCategoryMapper.deleteByPrimaryKey(id);
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(example);
		if(list==null || list.size()==0){
			TbContentCategory category=new TbContentCategory();
			category.setId(parentId);
			category.setIsParent(false);
			tbContentCategoryMapper.updateByPrimaryKeySelective(category);
		}
		return TaotaoResult.ok();
	}


	
	public TaotaoResult updateContentCategory(long id, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setId(id);
		contentCategory.setName(name);
		tbContentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		return TaotaoResult.ok();
	}




}
