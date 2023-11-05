package com.ssafy.tripinfo.model.service;

import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.util.PageNavigation;

import java.util.List;
import java.util.Map;

public interface TripinfoService {
    List<Tripinfo> listTripinfo(Map<String, String> map) throws Exception;
    int getTotalTripinfoCount(Map<String, Object> map) throws Exception;
    PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
