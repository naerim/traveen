package com.ssafy.tripinfo.model;

import java.util.List;

public class TripinfoList {
	private List<Tripinfo> tripinfos;
	private int currentPage;
	private int totalPageCount;


	public List<Tripinfo> getTripinfos() {
		return tripinfos;
	}

	public void setNotices(List<Tripinfo> tripinfos) {
		this.tripinfos = tripinfos;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
}
