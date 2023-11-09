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
    },
    {
      path: "/trip",
      name: "trip",
      component: () => import("@/views/TripView.vue"),
    },
    {
      path: "/aftertraveen",
      name: "aftertraveen",
      component: () => import("@/views/AfterTraveenView.vue"),
    },
    {
      path: "/notice",
      name: "notice",
      component: () => import("@/views/NoticeView.vue"),
    },
  ],
});

export default router;
