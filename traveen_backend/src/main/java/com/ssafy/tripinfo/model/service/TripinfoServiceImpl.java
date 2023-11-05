package com.ssafy.tripinfo.model.service;

import com.ssafy.tripinfo.model.Tripinfo;
import org.springframework.stereotype.Service;

import com.ssafy.tripinfo.model.mapper.TripinfoMapper;

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
		return tripinfoMapper.listTripinfo(map);
	}

	@Override
	public int getTotalTripinfoCount(Map<String, Object> map) throws Exception {
		return 0;
	}
}
