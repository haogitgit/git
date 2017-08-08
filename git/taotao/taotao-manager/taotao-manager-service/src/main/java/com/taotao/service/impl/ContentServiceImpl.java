package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	@Value("{BASE_REST_URL}")
	private String BASE_REST_URL;
	@Value("{REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;

	public EUDataResult getContentList(int page, int rows, long categoryId) {
		TbContentExample example = new TbContentExample();
		EUDataResult euDataResult = new EUDataResult();
		PageHelper.startPage(page, rows);
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		euDataResult.setRows(list);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		euDataResult.setTotal(pageInfo.getTotal());
		return euDataResult;
	}


	@Override
	public TaotaoResult insertContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		tbContentMapper.insert(content);
		try {
			HttpClientUtil.doGet(BASE_REST_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoResult .ok();
	}

}
