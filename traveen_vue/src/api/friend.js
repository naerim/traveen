import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 팔로잉 목록
const listFollowing = (userIdx, success, fail) => {
  local.get(`/friend/following/${userIdx}`).then(success).catch(fail);
};

export { listFollowing };
