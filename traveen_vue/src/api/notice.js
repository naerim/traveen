import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 공지사항 목록
const listNotice = (param, success, fail) => {
  local.get(`/notice/list`, { params: param }).then(success).catch(fail);
};

// 공지사항 상세 조회
const detailNotice = (idx, success, fail) => {
  local.get(`/notice/${idx}`).then(success).catch(fail);
};

// 공지사항 등록
const registNotice = (notice, success, fail) => {
  local.post(`/notice/regist`, JSON.stringify(notice)).then(success).catch(fail);
};

// 공지사항 수정
const modifyNotice = (notice, success, fail) => {
  local.put(`/notice/modify`, JSON.stringify(notice)).then(success).catch(fail);
};

// 공지사항 삭제
const deleteNotice = (idx, success, fail) => {
  local.delete(`/notice/delete/${idx}`).then(success).catch(fail);
};

export { listNotice, detailNotice, registNotice, modifyNotice, deleteNotice };
