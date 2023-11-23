package com.ssafy.qna.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.qna.model.Qna;
import com.ssafy.qna.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	private QnaMapper qnaMapper;

	public QnaServiceImpl(QnaMapper qnaMapper) {
		super();
		this.qnaMapper = qnaMapper;
	}

	@Override
	public List<Qna> listQna(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		param.put("key",  map.get("key") == null ? "" : map.get("key"));

		return qnaMapper.listQna(param);
	}

	@Override
	public void registQna(Qna qna) throws Exception {
		qnaMapper.registQna(qna);
	}

	@Override
	public void deleteQna(int idx) throws Exception {
		qnaMapper.deleteQna(idx);
	}

	@Override
	public Qna viewQna(int idx) throws Exception {
		return qnaMapper.viewQna(idx);
	}

	@Override
	public Qna getQna(int idx) throws Exception {
		return qnaMapper.getQna(idx);
	}
}
