package com.ssafy.qnaComment.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.qnaComment.model.QnaComment;

@Mapper
public interface QnaCommentMapper {
	List<QnaComment> listQnaComment() throws SQLException;
	void registQnaComment(QnaComment qnaComment) throws SQLException;
	void deleteQnaComment(int idx) throws SQLException;
	void modifyQnaComment(QnaComment qnaComment) throws SQLException;
	QnaComment viewQnaComment(int idx) throws SQLException;
	QnaComment getQnaComment(int idx) throws SQLException;
}
