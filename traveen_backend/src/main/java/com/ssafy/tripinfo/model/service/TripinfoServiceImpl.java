package com.ssafy.tripinfo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.tripinfo.model.LikeTrip;
import com.ssafy.tripinfo.model.Sido;
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
		param.put("type", map.get("type") == null ? "" : map.get("type"));
		param.put("order", map.get("order") == null ? "" : map.get("order"));
		param.put("category", map.get("category") == null ? "" : map.get("category"));
		param.put("sido", map.get("sido") == null ? "" : map.get("sido"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "50" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		List<Tripinfo> list = tripinfoMapper.listTripinfo(param);

		int totalTripinfoCount = tripinfoMapper.getTotalTripinfoCount(param);
		int totalPageCount = (totalTripinfoCount - 1) / sizePerPage + 1;

		TripinfoList tripinfoList = new TripinfoList();
		tripinfoList.setNotices(list);
		tripinfoList.setCurrentPage(currentPage);
		tripinfoList.setTotalPageCount(totalPageCount);
		return tripinfoList;
	}

	@Override
	public Tripinfo viewTripinfo(int idx) throws Exception {
		return tripinfoMapper.viewTripinfo(idx);
	}

	@Override
	public void updateHit(int idx) throws Exception {
		tripinfoMapper.updateHit(idx);
	}

	@Override
	public void updateLike(int idx) throws Exception {
		tripinfoMapper.updateLike(idx);
	}

	@Override
	public List<Sido> listSido() throws Exception {
		return tripinfoMapper.listSido();
	}

	@Override
	public void likeTripinfo(LikeTrip likeTrip) throws Exception {
		tripinfoMapper.likeTripinfo(likeTrip);
	}
}
