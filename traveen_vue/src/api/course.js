import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 코스 등록
const registCourse = (param, success, fail) => {
  local.post(`/course/regist`, JSON.stringify(param)).then(success).catch(fail);
};

// 코스 목록
const listCourse = (userId, success, fail) => {
  local.get(`/course/${userId}/list`).then(success).catch(fail);
};

export { registCourse, listCourse };
