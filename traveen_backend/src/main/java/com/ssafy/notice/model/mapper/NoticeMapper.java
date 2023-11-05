package com.ssafy.notice.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.notice.model.Notice;

@Mapper
public interface NoticeMapper {
	List<Notice> listNotice(Map<String, Object> map) throws SQLException;
	void registNotice(Map<String, String> map) throws SQLException;
	void modifyNotice(Map<String, String> map) throws SQLException;
	void deleteNotice(int idx) throws SQLException;
	Notice viewNotice(int idx) throws SQLException;

	Notice getNotice(int idx) throws SQLException;
	int getTotalNoticeCount(Map<String, Object> map) throws SQLException;
	int getTotalNoticeCountString(Map<String, String> map) throws SQLException;
	void updateHit(int idx) throws SQLException;
}
