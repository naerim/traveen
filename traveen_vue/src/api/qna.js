import { localAxios } from "@/util/http-commons";

const local = localAxios();

// qna 목록
const listQna = (param, success, fail) => {
  local.get(`/qna/list`).then(success).catch(fail);
};

// qna 등록
const registQna = (qna, success, fail) => {
  local.post(`/qna/regist`, JSON.stringify(qna)).then(success).catch(fail);
};

export { listQna, registQna };
