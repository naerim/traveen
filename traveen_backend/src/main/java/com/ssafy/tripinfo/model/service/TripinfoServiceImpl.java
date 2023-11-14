package com.ssafy.tripinfo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.notice.model.NoticeList;
import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.TripinfoList;
import com.ssafy.tripinfo.model.mapper.TripinfoMapper;

@Service
public class TripinfoServiceImpl implements TripinfoService {
	private TripinfoMapper tripinfoMapper;

	public TripinfoServiceImpl(TripinfoMapper tripinfoMapper) {
		super();
		this.tripinfoMapper = tripinfoMapper;
	}

	@Override
	public TripinfoList listTripinfo(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "10" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		String key = map.get("key");
		param.put("key", key == null ? "" : key);
//		if ("user_id".equals(key))
//			param.put("key", key == null ? "" : "b.user_id");
		List<Tripinfo> list = tripinfoMapper.listTripinfo(param);

//		if ("user_id".equals(key))
//			param.put("key", key == null ? "" : "user_id");
		int totalTripinfoCount = tripinfoMapper.getTotalTripinfoCount(param);
		int totalPageCount = (totalTripinfoCount - 1) / sizePerPage + 1;

		TripinfoList tripinfoList = new TripinfoList();
		tripinfoList.setNotices(list);
		tripinfoList.setCurrentPage(currentPage);
		tripinfoList.setTotalPageCount(totalPageCount);
		return tripinfoList;
	}
}
