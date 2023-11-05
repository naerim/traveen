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
		return noticeMapper.listNotice(map);
	}

	@Override
	public void registNotice(Map<String, String> map) throws Exception {
		noticeMapper.registNotice(map);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userId".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = noticeMapper.getTotalNoticeCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
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
	public int getTotalNoticeCount(Map<String, String> map) throws Exception {
		return noticeMapper.getTotalNoticeCount(map);
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
