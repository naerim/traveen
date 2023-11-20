package com.ssafy.tripinfo.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tripinfo.model.*;


public interface TripinfoService {
    TripinfoList listTripinfo(Map<String, String> map) throws Exception;
    Tripinfo viewTripinfo(int idx) throws Exception;
    void updateHit(int idx) throws Exception;
    void updateLike(int idx) throws Exception;
    void likeTripinfo(LikeTripParam likeTripParam) throws Exception;
    void deleteLikeTripinfo(int likeTripIdx) throws Exception;
    int getTripinfoByLikeTripIdx(int likeTripIdx) throws Exception;
    List<Tripinfo> listLikeTrip(String userId) throws Exception;
    List<Sido> listSido() throws Exception;
}
