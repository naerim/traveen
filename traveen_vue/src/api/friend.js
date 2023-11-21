import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 팔로잉 목록
const listFollowing = (userIdx, success, fail) => {
  local.get(`/user/following/${userIdx}`).then(success).catch(fail);
};

// 팔로워 목록
const listFollower = (userIdx, success, fail) => {
  local.get(`/user/follower/${userIdx}`).then(success).catch(fail);
};

// 팔로잉 취소
const deleteFollowing = (userIdx, success, fail) => {
  local.delete(`/user/following/delete/${userIdx}`).then(success).catch(fail);
};

// 팔로워 취소
const deleteFollower = (userIdx, success, fail) => {
  local.delete(`/user/follower/delete/${userIdx}`).then(success).catch(fail);
};
export { listFollowing, listFollower, deleteFollowing, deleteFollower };
