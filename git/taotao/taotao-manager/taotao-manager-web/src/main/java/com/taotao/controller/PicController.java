package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PicService;

@Controller
public class PicController {
	@Autowired
	private PicService picService;
	@RequestMapping("pic/upload")
	@ResponseBody
	public String uploadPicture (MultipartFile uploadFile)
	{
		Map map = picService.uploadPicture(uploadFile);
		String json = JsonUtils.objectToJson(map);
		return json;
	}
}
