package com.ssafy.notice.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Notice> listNotice(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.TRIPINFO_LIST_SIZE - SizeConstant.TRIPINFO_LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.TRIPINFO_LIST_SIZE);
		return noticeMapper.listNotice(param);
	}

	@Override
	public void registNotice(Map<String, String> map) throws Exception {
		noticeMapper.registNotice(map);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int navSize = SizeConstant.TRIPINFO_NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.TRIPINFO_LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(navSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = noticeMapper.getTotalNoticeCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= navSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / navSize * navSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public void modifyNotice(Map<String, String> map) throws Exception {
		noticeMapper.modifyNotice(map);
	}

	@Override
	public void deleteNotice(int idx) throws Exception {
		noticeMapper.deleteNotice(idx);
	}
	

	@Override
	public int getTotalNoticeCount(Map<String, Object> map) throws Exception {
		return noticeMapper.getTotalNoticeCount(map);
	}

	@Override
	public int getTotalNoticeCountString(Map<String, String> map) throws Exception {
		return noticeMapper.getTotalNoticeCountString(map);
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
