package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public TaotaoResult getItemBaseInf(long itemId) {
		//
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId+":base");
			if(!StringUtils.isBlank(json))
			{
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				return TaotaoResult.ok(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId+":base", JsonUtils.objectToJson(item));
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId+":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return TaotaoResult.ok(item);
	}

	@Override
	public TaotaoResult getItemDesc(long itemId) {
		//
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId+":desc");
			if(!StringUtils.isBlank(json))
			{
				TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return TaotaoResult.ok(itemDesc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId+":desc", JsonUtils.objectToJson(itemDesc));
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId+":desc", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return TaotaoResult.ok(itemDesc);
		
	}

	@Override
	public TaotaoResult getItemParam(long itemId) {
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId+":param");
			if(!StringUtils.isBlank(json))
			{
				TbItemParamItem itemParam = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
				return TaotaoResult.ok(itemParam);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TbItemParamItemExample example= new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(list!=null && list.size()>0)
		{
			TbItemParamItem itemParam = list.get(0);
			try {
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId+":param", JsonUtils.objectToJson(itemParam));
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId+":param", REDIS_ITEM_EXPIRE);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return TaotaoResult.ok(itemParam);
		}
		return TaotaoResult.build(400, "无此商品规格");
	}

}
