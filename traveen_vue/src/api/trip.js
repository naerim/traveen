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

export { listTrip, detailTrip, listSido };
