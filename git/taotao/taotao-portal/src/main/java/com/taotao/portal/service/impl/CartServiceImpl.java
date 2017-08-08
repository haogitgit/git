package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITEM_INFO_URL}")
	private String ITEM_INFO_URL;
	@Override
	public TaotaoResult addCartItem(long itemId, int num,HttpServletRequest request, HttpServletResponse response) {
		CartItem cartItem = null;
		List<CartItem> list = getCartItemList(request);
		for (CartItem cart : list) {
			if(itemId==cart.getId())
			{
				cart.setNum(cart.getNum()+num);
				cartItem =cart;
				break;
			}
		}
		if(cartItem==null)
		{
			cartItem = new CartItem();
			String json = HttpClientUtil.doGet(REST_BASE_URL+ITEM_INFO_URL+itemId);
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItem.class);
			if (taotaoResult.getStatus() == 200) {
				TbItem item = (TbItem) taotaoResult.getData();
				cartItem.setId(item.getId());
				cartItem.setTitle(item.getTitle());
				cartItem.setImage(item.getImage() == null ? "":item.getImage().split(",")[0]);
				cartItem.setNum(num);
				cartItem.setPrice(item.getPrice());
			}
			//添加到购物车列表
			list.add(cartItem);	
		}
		
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list), true);
		
		return TaotaoResult.ok();
	}
	private List<CartItem> getCartItemList(HttpServletRequest request) {
		
		String json = CookieUtils.getCookieValue(request, "TT_CART", true);
		if(json==null)
		{
			return new ArrayList<>();
		}
		try {
			List<CartItem> list = JsonUtils.jsonToList(json, CartItem.class);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<>();
		
		
	}
	@Override
	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
		List<CartItem> itemList = getCartItemList(request);
		return itemList;
	}
	@Override
	public TaotaoResult deleteCartItem(Long itemId,HttpServletRequest request, HttpServletResponse response) {
		List<CartItem> itemList = getCartItemList(request);
		for (CartItem cartItem : itemList) {
			if(cartItem.getId()==itemId)
			{
				itemList.remove(cartItem);
				break;
			}
			
		}
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), true);
		
		return TaotaoResult.ok();
	}

}
