package com.ssafy.notice.model.service;

import java.util.Map;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.NoticeList;

public interface NoticeService {
	NoticeList listNotice(Map<String, String> map) throws Exception;
	void registNotice(Notice notice) throws Exception;
	void modifyNotice(Notice notice) throws Exception;
	void deleteNotice(int idx) throws Exception;
	Notice viewNotice(int idx) throws Exception;
	Notice getNotice(int idx) throws Exception;
	void updateHit(int idx) throws Exception;
}
