package com.ssafy.tripinfo.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripinfo.model.Tripinfo;

@Mapper
public interface TripinfoMapper {
    List<Tripinfo> listTripinfo(Tripinfo tripinfo) throws SQLException;
    int getTotalTripinfoCount(Tripinfo tripinfo) throws SQLException;
}
