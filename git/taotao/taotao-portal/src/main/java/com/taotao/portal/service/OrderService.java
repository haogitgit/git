package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.Order;

public interface OrderService {
	
	String createOrder(Order order);
	TaotaoResult getOrderById(String orderId);

}
