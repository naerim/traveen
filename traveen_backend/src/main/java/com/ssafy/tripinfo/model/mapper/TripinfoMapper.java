package com.ssafy.tripinfo.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripinfo.model.LikeTrip;
import com.ssafy.tripinfo.model.Sido;
import com.ssafy.tripinfo.model.Tripinfo;

@Mapper
public interface TripinfoMapper {
    List<Tripinfo> listTripinfo(Map<String, Object> map) throws SQLException;
    Tripinfo viewTripinfo(int idx) throws SQLException;
    int getTotalTripinfoCount(Map<String, Object> param) throws SQLException;
    void likeTripinfo(LikeTrip likeTrip) throws SQLException;
    void deleteLikeTripinfo(int tripinfoIdx) throws SQLException;
    void updateHit(int idx) throws SQLException;
    void updateLike(int idx) throws SQLException;
    void updateDeleteLike(int idx) throws SQLException;
    int getTripinfoByLikeTripIdx(int likeTripIdx) throws SQLException;
    
    List<Sido> listSido() throws SQLException;
    
}
