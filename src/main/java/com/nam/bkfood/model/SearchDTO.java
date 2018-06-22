package com.nam.bkfood.model;

import java.io.Serializable;

public class SearchDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	public static final int ASC = 1;
	public static final int DESC = -1;
	public static final int MAX_10 = 8;
	public static final int MAX_50 = 50;
	private String keyword;
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	private Integer sortOrder;

	public SearchDTO() {
		page = 1;
		pageSize = 2;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
