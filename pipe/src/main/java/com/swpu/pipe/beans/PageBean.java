package com.swpu.pipe.beans;

import java.util.List;

/**
 * 分页器
 * @author Allen
 *
 * @param <T> 分页对象类型（这里是用户信息）
 */
public class PageBean<T> {

	private List<T> list;
	private int currentPage;
	private int pageSize;
	private int totalPage;
	
	public PageBean() { 
		
	}
	
	
	public PageBean(List<T> list, int currentPage, int pageSize, int totalPage) {
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}	
	
	
}
