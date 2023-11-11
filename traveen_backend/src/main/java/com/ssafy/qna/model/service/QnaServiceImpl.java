package com.ssafy.qna.model.service;

import java.util.List;

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
	public List<Qna> listQna() throws Exception {
		return qnaMapper.listQna();
	}

	@Override
	public void registQna(Qna qna) throws Exception {
		qnaMapper.registQna(qna);
		
	}

	@Override
	public void modifyQna(Qna qna) throws Exception {
		qnaMapper.modifyQna(qna);
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
