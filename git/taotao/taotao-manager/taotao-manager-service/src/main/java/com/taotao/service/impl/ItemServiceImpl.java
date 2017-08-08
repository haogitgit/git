package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	
	public TbItem getItemById(Long itemId) {
		TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	
	public EUDataResult getItemList(int page, int rows) {
		EUDataResult euDataResult = new EUDataResult();
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		euDataResult.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		euDataResult.setTotal(pageInfo.getTotal());
		return euDataResult;
	}

	@Override
	public TaotaoResult creatItem(TbItem item,String desc,String itemParam) throws Exception {
		
		long itemId = IDUtils.genItemId();
		Date date = new Date();
		item.setId(itemId);
		item.setStatus((byte)1);
		item.setCreated(date);
		item.setUpdated(date);
		tbItemMapper.insert(item);
		TaotaoResult result = insertItemDesc(itemId, desc);
		if(result.getStatus()!=200)
		{
			throw new Exception();
		}
		result = insertItemParamItem(itemId, itemParam);
		if(result.getStatus()!=200)
		{
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	
	public TaotaoResult insertItemDesc(Long itemId,String desc)
	{
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		tbItemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
		
	}
	public TaotaoResult insertItemParamItem(Long itemId,String itemParam)
	{
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		itemParamItem.setParamData(itemParam);
		tbItemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
		
	}
}
