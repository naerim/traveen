package com.ssafy.qnaComment.model.service;

import java.sql.SQLException;

import com.ssafy.qna.model.Qna;
import com.ssafy.qnaComment.model.QnaComment;

public interface QnaCommentService {
	void registQnaComment(QnaComment qnaComment) throws SQLException;
	void deleteQnaComment(int idx) throws SQLException;
	void modifyQnaComment(QnaComment qnaComment) throws SQLException;
	QnaComment viewQnaComment(int idx) throws SQLException;
	QnaComment getQnaComment(int idx) throws SQLException;
}
