import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 여행 후기 등록
const registPost = (param, success, fail) => {
  local.post(`/post/regist`, JSON.stringify(param)).then(success).catch(fail);
};

// 여행 후기 글 목록
const listPost = (param, success, fail) => {
  local.get(`/post/list`, { params: param }).then(success).catch(fail);
};

// 여행 후기 글 상세 조회
const detailPost = (idx, success, fail) => {
  local.get(`/post/view/${idx}`).then(success).catch(fail);
};

// 여행 후기 글 삭제
const deletePost = (idx, success, fail) => {
  local.delete(`/post/delete/${idx}`).then(success).catch(fail);
};

// 여행 후기 글에 속한 아이템 목록
const listPostItem = (postIdx, success, fail) => {
  local.get(`/post/list/${postIdx}`).then(success).catch(fail);
};

export { registPost, listPost, detailPost, deletePost, listPostItem };
