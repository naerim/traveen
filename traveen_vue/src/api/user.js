import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 회원가입
const join = (user, success, fail) => {
  local.post(`/user/join`, JSON.stringify(user)).then(success).catch(fail);
};

// 아이디 중복 체크
const idCheck = (userId, success, fail) => {
  local.get(`/user/idCheck/${userId}`).then(success).catch(fail);
};

async function userConfirm(param, success, fail) {
  await local.post(`/user/login`, param).then(success).catch(fail);
}

export { join, idCheck, userConfirm };
