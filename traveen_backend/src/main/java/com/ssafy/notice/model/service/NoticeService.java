package com.ssafy.notice.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.notice.model.Notice;

public interface NoticeService {
	List<Notice> listNotice(Map<String, Object> map) throws Exception;
	void registNotice(Notice notice) throws Exception;
	void modifyArticle(Notice notice) throws Exception;
	void deleteArticle(int articleNo) throws Exception;

//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	int getTotalNoticeCount(Map<String, Object> map) throws Exception;
	Notice getNotice(int idx) throws Exception;
	void updateHit(int idx) throws Exception;
}
