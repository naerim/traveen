package com.ssafy.tripinfo.model.service;

import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;
import org.springframework.stereotype.Service;

import com.ssafy.tripinfo.model.mapper.TripinfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripinfoServiceImpl implements TripinfoService {
	private TripinfoMapper tripinfoMapper;

	public TripinfoServiceImpl(TripinfoMapper tripinfoMapper) {
		super();
		this.tripinfoMapper = tripinfoMapper;
	}

	@Override
	public List<Tripinfo> listTripinfo(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.TRIPINFO_LIST_SIZE - SizeConstant.TRIPINFO_LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.TRIPINFO_LIST_SIZE);
		return tripinfoMapper.listTripinfo(param);
	}

	@Override
	public int getTotalTripinfoCount(Map<String, Object> map) throws Exception {
		return tripinfoMapper.getTotalTripinfoCount(map);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int navSize = SizeConstant.TRIPINFO_NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.TRIPINFO_LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(navSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = tripinfoMapper.getTotalTripinfoCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= navSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / navSize * navSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}
}
