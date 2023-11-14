import { localAxios } from "@/util/http-commons";

const local = localAxios();

// trip 목록
const listTrip = (param, success, fail) => {
  local.get(`/tripinfo/list`, { params: param }).then(success).catch(fail);
};

// trip idx로 qnaComment 가져오기
// const viewQnaComment = (qna_idx, success, fail) => {
//   local.get(`/qna/qnaComment/view/${qna_idx}`).then(success).catch(fail);
// };

export { listTrip };
