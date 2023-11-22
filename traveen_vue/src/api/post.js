import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 여행 후기 등록
const registPost = (param, success, fail) => {
  local.post(`/post/regist`, JSON.stringify(param)).then(success).catch(fail);
};

export { registPost };
