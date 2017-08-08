package com.taotao.service;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById (Long itemId);
	EUDataResult getItemList(int page,int rows);
	TaotaoResult creatItem(TbItem item,String desc,String itemParam) throws Exception;
}
