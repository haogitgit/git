package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PicService;

@Service
public class PicServiceImpl implements PicService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMG_BASE_URL}")
	private String IMG_BASE_URL;
	
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		
		try {
			String oldName = uploadFile.getOriginalFilename();
			String newName = IDUtils.genImageName();
			newName = newName+oldName.substring(oldName.lastIndexOf("."));
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean flag = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, 
					imagePath,newName, uploadFile.getInputStream());
			if(!flag){
				resultMap.put("error", 1);
				resultMap.put("message", "fail");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMG_BASE_URL+imagePath+"/"+newName);
			return resultMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultMap.put("error", 1);
			resultMap.put("message", "fail");
			return resultMap;
		}
	}

}
