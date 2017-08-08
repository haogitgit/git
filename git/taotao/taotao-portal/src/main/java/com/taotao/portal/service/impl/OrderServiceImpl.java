package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	@Value("${ORDER_INFO_URL}")
	private String ORDER_INFO_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		TaotaoResult taotaoResult = TaotaoResult.format(json);
		if (taotaoResult.getStatus() == 200) {
			Object orderId =  taotaoResult.getData();
			return orderId.toString();
		}
		return "";
	}


	@Override
	public TaotaoResult getOrderById(String orderId) {
		String json = HttpClientUtil.doGet(ORDER_BASE_URL + ORDER_CREATE_URL+orderId);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, Order.class);
		if (taotaoResult.getStatus() == 200) {
			Order order = (Order) taotaoResult.getData();
			return taotaoResult.ok(order);
		}
		return taotaoResult.build(500, "订单错误");
	}

}
