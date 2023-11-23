package com.ssafy.qna.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.qna.model.Qna;

public interface QnaService {
	List<Qna> listQna(Map<String, String> map) throws Exception;
	void registQna(Qna qna) throws Exception;
	void deleteQna(int idx) throws Exception;
	Qna viewQna(int idx) throws Exception;
	Qna getQna(int idx) throws Exception;
}