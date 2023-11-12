package com.ssafy.notice.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.notice.model.NoticeList;
import org.springframework.stereotype.Service;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.mapper.NoticeMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class NoticeServiceImpl implements NoticeService {
	private NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public NoticeList listNotice(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "10" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);

		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "b.user_id");
		List<Notice> list = noticeMapper.listNotice(param);

		if ("user_id".equals(key))
			param.put("key", key == null ? "" : "user_id");
		int totalNoticeCount = noticeMapper.getTotalNoticeCount(param);
		int totalPageCount = (totalNoticeCount - 1) / sizePerPage + 1;

		NoticeList noticeList = new NoticeList();
		noticeList.setNotices(list);
		noticeList.setCurrentPage(currentPage);
		noticeList.setTotalPageCount(totalPageCount);
		return noticeList;
	}

	@Override
	public void registNotice(Notice notice) throws Exception {
		noticeMapper.registNotice(notice);
	}

	@Override
	public void modifyNotice(Notice notice) throws Exception {
		noticeMapper.modifyNotice(notice);
	}

	@Override
	public void deleteNotice(int idx) throws Exception {
		noticeMapper.deleteNotice(idx);
	}

	@Override
	public Notice viewNotice(int idx) throws Exception {
		return noticeMapper.viewNotice(idx);
	}

	@Override
	public void updateHit(int idx) throws Exception {
		noticeMapper.updateHit(idx);
	}

	@Override
	public Notice getNotice(int idx) throws Exception {
		return noticeMapper.getNotice(idx);
	}
}
