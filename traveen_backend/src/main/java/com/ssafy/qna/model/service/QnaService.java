package com.ssafy.qna.model.service;

import java.util.List;

import com.ssafy.qna.model.Qna;

public interface QnaService {
	List<Qna> listQna() throws Exception;
	void registQna(Qna qna) throws Exception;
	void deleteQna(int idx) throws Exception;
	Qna viewQna(int idx) throws Exception;
	Qna getQna(int idx) throws Exception;
}