package com.student.pojo;

import java.util.List;

public class PageInfo {
	
	private int totolNum;
	
	private int pageNo;
	
	private List<?> objectList;

	public int getTotolNum() {
		return totolNum;
	}

	public void setTotolNum(int totolNum) {
		this.totolNum = totolNum;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<?> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<?> objectList) {
		this.objectList = objectList;
	}

	
}
