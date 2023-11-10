package com.ssafy.tripinfo.model.service;

import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.util.PageNavigation;

import java.util.List;
import java.util.Map;

public interface TripinfoService {
    List<Tripinfo> listTripinfo(Tripinfo tripinfo) throws Exception;
    int getTotalTripinfoCount(Tripinfo tripinfo) throws Exception;
//    PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
