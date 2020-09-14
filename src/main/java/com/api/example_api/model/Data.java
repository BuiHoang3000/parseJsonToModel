package com.api.example_api.model;

import java.util.List;

public class Data{
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<User> data;
	private Ad ad;
	
    public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int gettotal_pages() {
		return total_pages;
	}

	public void settotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	@Override
    public String toString()
    {
        return	"page: " + page + "\n" +
        		"per_ page: " + per_page + "\n" +
        		"total: " + total + "\n" +
        		"total_pages: " + total_pages + "\n" +
        		"data: " + data + "\n" +
        		"ad: " + ad;
    }
}

