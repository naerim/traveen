package com.ssafy.qnaComment.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.qnaComment.model.QnaComment;

public interface QnaCommentService {
	List<QnaComment> listQnaComment() throws Exception;
	void registQnaComment(QnaComment qnaComment) throws SQLException;
	void deleteQnaComment(int idx) throws SQLException;
	void modifyQnaComment(QnaComment qnaComment) throws SQLException;
	QnaComment viewQnaComment(int idx) throws SQLException;
	QnaComment getQnaComment(int idx) throws SQLException;
}
