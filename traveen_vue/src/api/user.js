import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 회원가입
const join = (user, success, fail) => {
  local.post(`/user/join`, JSON.stringify(user)).then(success).catch(fail);
};

// refresh token 넣기
const addToken = (user, success, fail) => {
  local.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
};

// 아이디 중복 체크
const idCheck = (userId, success, fail) => {
  local.get(`/user/idCheck/${userId}`).then(success).catch(fail);
};

async function userConfirm(param, success, fail) {
  await local.post(`/user/login`, param).then(success).catch(fail);
}

// 회원 정보 조회
const detailUser = (userId, success, fail) => {
  local.get(`/user/myinfo/${userId}`).then(success).catch(fail);
};

// 회원 정보 수정
const modifyUser = (user, success, fail) => {
  local
    .put(`/user/myinfo/modify`, JSON.stringify(user))
    .then(success)
    .catch(fail);
};

// 회원 탈퇴
const deleteUser = (userId, success, fail) => {
  local.delete(`/user/delete/${userId}`).then(success).catch(fail);
};

async function findById(userid, success, fail) {
  local.defaults.headers["Authorization"] =
    sessionStorage.getItem("accessToken");
  await local.get(`/user/myinfo/${userid}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  local.defaults.headers["refreshToken"] =
    sessionStorage.getItem("refreshToken"); //axios header에 refresh-token 셋팅
  await local.post(`/user/refresh`, user).then(success).catch(fail);
}

async function logout(userid, success, fail) {
  await local.get(`/user/logout/${userid}`).then(success).catch(fail);
}

export {
  join,
  idCheck,
  userConfirm,
  detailUser,
  modifyUser,
  deleteUser,
  findById,
  tokenRegeneration,
  logout,
  addToken,
};
