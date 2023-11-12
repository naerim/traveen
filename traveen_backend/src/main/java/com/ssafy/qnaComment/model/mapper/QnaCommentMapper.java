package com.ssafy.qnaComment.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.qna.model.Qna;
import com.ssafy.qnaComment.model.QnaComment;

@Mapper
public interface QnaCommentMapper {
	void registQnaComment(QnaComment qnaComment) throws SQLException;
	void deleteQnaComment(int idx) throws SQLException;
	void modifyQnaComment(QnaComment qnaComment) throws SQLException;
	QnaComment viewQnaComment(int idx) throws SQLException;
	QnaComment getQnaComment(int idx) throws SQLException;
}
