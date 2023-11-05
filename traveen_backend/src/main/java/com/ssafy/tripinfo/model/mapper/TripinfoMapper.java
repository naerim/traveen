package com.ssafy.tripinfo.model.mapper;

import com.ssafy.tripinfo.model.Tripinfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface TripinfoMapper {
    List<Tripinfo> listTripinfo(Map<String, String> map) throws SQLException;
    int getTotalTripinfoCount(Map<String, Object> map) throws SQLException;
}
