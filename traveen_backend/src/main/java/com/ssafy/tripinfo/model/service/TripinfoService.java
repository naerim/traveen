package com.ssafy.tripinfo.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.tripinfo.model.Sido;
import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.TripinfoList;


public interface TripinfoService {
    TripinfoList listTripinfo(Map<String, String> map) throws Exception;
    Tripinfo viewTripinfo(int idx) throws Exception;
    void updateHit(int idx) throws Exception;
    
    List<Sido> listSido() throws Exception;
}
