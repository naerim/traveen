package com.ssafy.qna.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.qna.model.Qna;

@Mapper
public interface QnaMapper {
	List<Qna> listQna() throws SQLException;
	void registQna(Qna qna) throws SQLException;
	void modifyQna(Qna qna) throws SQLException;
	void deleteQna(int idx) throws SQLException;
	Qna viewQna(int idx) throws SQLException;
	Qna getQna(int idx) throws SQLException;
}