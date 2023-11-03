package com.ssafy.notice.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.notice.model.Notice;

@Mapper
public interface NoticeMapper {
	List<Notice> listNotice(Map<String, Object> map) throws SQLException;
	void registNotice(Notice notice) throws SQLException;
	void modifyArticle(Notice notice) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;

	int getTotalNoticeCount(Map<String, Object> map) throws SQLException;
	Notice getNotice(int idx) throws SQLException;
	void updateHit(int idx) throws SQLException;
}
