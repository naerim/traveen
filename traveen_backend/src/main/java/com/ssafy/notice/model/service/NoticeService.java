package com.ssafy.notice.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.notice.model.Notice;
import com.ssafy.util.PageNavigation;

public interface NoticeService {
	List<Notice> listNotice(Map<String, String> map) throws Exception;
	void registNotice(Map<String, String> map) throws Exception;
	void modifyNotice(Map<String, String> map) throws Exception;
	void deleteNotice(int idx) throws Exception;
	Notice viewNotice(int idx) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	Notice getNotice(int idx) throws Exception;
	int getTotalNoticeCount(Map<String, String> map) throws Exception;
	void updateHit(int idx) throws Exception;
}
