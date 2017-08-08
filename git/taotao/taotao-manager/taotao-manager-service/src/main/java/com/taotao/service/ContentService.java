package com.taotao.service;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	EUDataResult getContentList(int page,int rows,long categoryId);
	TaotaoResult insertContent(TbContent content);

}
