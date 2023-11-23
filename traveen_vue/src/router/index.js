import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";

const onlyAuthUser = async (to, from, next) => {
  const memberStore = useMemberStore();
  const { userInfo, isValidToken } = storeToRefs(memberStore);
  const { getUserInfo } = memberStore;
  let token = sessionStorage.getItem("accessToken");
  console.log("로그인 처리 전", userInfo, token);

  if (userInfo.value !== null && token) {
    console.log("토큰 유효성 체크하러 가자!!!!");
    await getUserInfo(token);
  }
  if (!isValidToken.value || userInfo.value === null) {
    alert("로그인이 필요한 페이지입니다..");
    next({ name: "login" });
    // router.push({ name: "login" });
  } else {
    console.log("로그인 했다!!!!!!!!!!!!!.");
    next();
  }
};

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/login",
      name: "login",
      component: () => import("@/views/LoginView.vue"),
    },
    {
      path: "/join",
      name: "join",
      component: () => import("@/views/JoinView.vue"),
    },
    {
      path: "/findPwd",
      name: "findPwd",
      component: () => import("@/views/findPwdView.vue"),
    },
    {
      path: "/mypage",
      name: "mypage",
      component: () => import("@/views/MyPageView.vue"),
      redirect: { name: "myinfo" },
      children: [
        {
          path: "myinfo",
          name: "myinfo",
          component: () => import("@/views/MyInfoView.vue"),
        },
        {
          path: "mytrip",
          name: "mytrip",
          component: () => import("@/views/MyTripView.vue"),
        },
        {
          path: "myactive",
          name: "myactive",
          component: () => import("@/views/MyActiveView.vue"),
        },
        {
          path: "myfriend",
          name: "myfriend",
          component: () => import("@/views/MyFriendView.vue"),
        },
      ],
    },
    {
      path: "/trip",
      name: "trip",
      component: () => import("@/views/TripView.vue"),
      children: [
        {
          path: "list",
          name: "trip-list",
          component: () => import("@/components/trip/TripList.vue"),
        },
        {
          path: "detail/:idx",
          name: "trip-detail",
          component: () => import("@/components/trip/TripModal.vue"),
        },
        {
          path: "list/:word",
          name: "trip-list-popular",
          component: () => import("@/components/trip/TripList.vue"),
        },
      ],
    },
    {
      path: "/course",
      name: "course",
      component: () => import("@/views/CourseView.vue"),
      redirect: { name: "course-write" },
      children: [
        {
          path: "write",
          name: "course-write",
          component: () => import("@/components/course/CourseWrite.vue"),
        },
        {
          path: "modify/:idx",
          name: "course-modify",
          component: () => import("@/components/course/CourseModify.vue"),
        },
      ],
    },
    {
      path: "/aftertraveen",
      name: "aftertraveen",
      beforeEnter: onlyAuthUser,
      component: () => import("@/views/AfterTraveenView.vue"),
      redirect: { name: "aftertraveen-list" },
      children: [
        {
          path: "list",
          name: "aftertraveen-list",
          component: () =>
            import("@/components/aftertraveen/AftertraveenList.vue"),
        },
        {
          path: "write",
          name: "aftertraveen-write",
          component: () =>
            import("@/components/aftertraveen/AftertraveenWrite.vue"),
        },
        {
          path: "detail/:idx",
          name: "aftertraveen-detail",
          component: () =>
            import("@/components/aftertraveen/AftertraveenDetail.vue"),
        },
        {
          path: "modify/:idx",
          name: "aftertraveen-modify",
          component: () =>
            import("@/components/aftertraveen/AftertraveenModify.vue"),
        },
      ],
    },
    {
      path: "/center",
      name: "center",
      beforeEnter: onlyAuthUser,
      component: () => import("@/views/CenterView.vue"),
      redirect: { name: "notice-list" },
      children: [
        {
          path: "notice",
          name: "notice",
          component: () => import("@/views/NoticeView.vue"),
          redirect: { name: "notice-list" },
          children: [
            {
              path: "list",
              name: "notice-list",
              component: () => import("@/components/notice/NoticeList.vue"),
            },
            {
              path: "detail/:idx",
              name: "notice-detail",
              component: () => import("@/components/notice/NoticeDetail.vue"),
            },
            {
              path: "modify/:idx",
              name: "notice-modify",
              component: () => import("@/components/notice/NoticeModify.vue"),
            },
            {
              path: "write",
              name: "notice-write",
              component: () => import("@/components/notice/NoticeWrite.vue"),
            },
          ],
        },
        {
          path: "qna",
          name: "qna",
          component: () => import("@/views/QnaView.vue"),
          children: [
            {
              path: "list",
              name: "qna-list",
              component: () => import("@/components/qna/QnaList.vue"),
            },
          ],
        },
      ],
    },
  ],
});

export default router;
