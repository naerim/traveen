import { localAxios } from "@/util/http-commons";

const local = localAxios();

// trip 목록
const listTrip = (param, success, fail) => {
  local.get(`/tripinfo/list`, { params: param }).then(success).catch(fail);
};

// trip idx로 trip 가져오기
const detailTrip = (idx, success, fail) => {
  local.get(`/tripinfo/view/${idx}`).then(success).catch(fail);
};

// sido 목록
const listSido = (success, fail) => {
  local.get(`/tripinfo/sidoList`).then(success).catch(fail);
};

// 여행지 좋아요
const likeTrip = (tripLikeParam, success, fail) => {
  local.post(`/tripinfo/like`, JSON.stringify(tripLikeParam)).then(success).catch(fail);
};

// 여행지 좋아요 취소
const deleteLikeTrip = (tripinfoIdx, success, fail) => {
  local.delete(`/tripinfo/like/delete/${tripinfoIdx}`).then(success).catch(fail);
};

// 사용자 코스 목록
const listLikeTrip = (userId, success, fail) => {
  local.get(`/tripinfo/${userId}/list`).then(success).catch(fail);
};

export { listTrip, detailTrip, listSido, likeTrip, deleteLikeTrip, listLikeTrip };
