package com.ssafy.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	private NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public List<Notice> listNotice(Map<String, Object> map) throws Exception {
		return noticeMapper.listNotice(map);
	}

	@Override
	public void registNotice(Notice notice) throws Exception {
		noticeMapper.registNotice(notice);
	}

	@Override
	public void modifyArticle(Notice notice) throws Exception {
		noticeMapper.modifyArticle(notice);
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		noticeMapper.deleteArticle(articleNo);
	}

	@Override
	public int getTotalNoticeCount(Map<String, Object> map) throws Exception {
		return noticeMapper.getTotalNoticeCount(map);
	}

	@Override
	public Notice getNotice(int idx) throws Exception {
		return noticeMapper.getNotice(idx);
	}

	@Override
	public void updateHit(int idx) throws Exception {
		noticeMapper.updateHit(idx);
	}
}
