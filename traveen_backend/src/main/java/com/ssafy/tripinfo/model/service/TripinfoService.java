package com.ssafy.tripinfo.model.service;

import java.util.Map;

import com.ssafy.tripinfo.model.TripinfoList;

public interface TripinfoService {
    TripinfoList listTripinfo(Map<String, String> map) throws Exception;
}
