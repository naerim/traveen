import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

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
    },
    {
      path: "/course",
      name: "course",
      component: () => import("@/views/CourseView.vue"),
    },
    {
      path: "/aftertraveen",
      name: "aftertraveen",
      component: () => import("@/views/AfterTraveenView.vue"),
      redirect: { name: "aftertraveen-list" },
      children: [
        {
          path: "list",
          name: "aftertraveen-list",
          component: () => import("@/components/aftertraveen/AftertraveenList.vue"),
        },
      ],
    },
    {
      path: "/center",
      name: "center",
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
