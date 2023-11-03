package com.ssafy.tripinfo.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.tripinfo.model.mapper.TripinfoMapper;

@Service
public class TripinfoServiceImpl implements TripinfoService {
	private TripinfoMapper tripinfoMapper;

	public TripinfoServiceImpl(TripinfoMapper tripinfoMapper) {
		super();
		this.tripinfoMapper = tripinfoMapper;
	}
}
