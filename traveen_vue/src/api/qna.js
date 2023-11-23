import { localAxios } from "@/util/http-commons";

const local = localAxios();

// qna 목록
const listQna = (param, success, fail) => {
  local.get(`/qna/list`, { params: param }).then(success).catch(fail);
};

// qna 등록
const registQna = (qna, success, fail) => {
  local.post(`/qna/regist`, JSON.stringify(qna)).then(success).catch(fail);
};

// qna 삭제
const deleteQna = (qna_idx, success, fail) => {
  local.delete(`/qna/delete/${qna_idx}`).then(success).catch(fail);
};

// qna comment 목록
const listQnaComment = (param, success, fail) => {
  local.get(`/qna/qnaComment/list`).then(success).catch(fail);
};

// qnaComment 등록
const registQnaComment = (qnaComment, success, fail) => {
  local.post(`/qna/qnaComment/regist`, JSON.stringify(qnaComment)).then(success).catch(fail);
};

// qnaComment 수정
const modifyQnaComment = (qnaComment, success, fail) => {
  local.put(`/qna/qnaComment/modify`, JSON.stringify(qnaComment)).then(success).catch(fail);
};

// qnaComment 삭제
const deleteQnaComment = (qna_idx, success, fail) => {
  local.delete(`/qna/qnaComment/delete/${qna_idx}`).then(success).catch(fail);
};

// qna idx로 qnaComment 가져오기
const viewQnaComment = (qna_idx, success, fail) => {
  local.get(`/qna/qnaComment/view/${qna_idx}`).then(success).catch(fail);
};

export {
  listQna,
  registQna,
  deleteQna,
  listQnaComment,
  registQnaComment,
  deleteQnaComment,
  viewQnaComment,
  modifyQnaComment,
};
