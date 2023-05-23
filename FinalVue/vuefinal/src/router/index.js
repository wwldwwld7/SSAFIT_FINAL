import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import VideoView from "../views/VideoView.vue";
import MyPage from "../views/MyPage.vue";
import GuestPage from "../views/GuestPage.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/video",
    name: "video",
    component: VideoView,
    children: [
      {
        path: "detail",
        name: "detail",
        component: () => import("@/components/video/DetailVideo.vue"),
      },
      {
        path: "comment",
        name: "comment",
        component: () => import("@/components/video/DetailVideoComment.vue"),
      },
      {
        path: "",
        name: "search",
        component: () => import("@/components/video/SearchVideo.vue"),
      },
      {
        path: "searchResult",
        name: "searchResult",
        component: () => import("@/components/video/SearchVideoResult.vue"),
      },
      {
        path: "resultList",
        name: "resultList",
        component: () => import("@/components/video/SearchVideoResultList.vue"),
      },
      {
        path: "videoCommentList",
        name: "videoCommentList",
        component: () =>
          import("@/components/video/DetailVideoCommentList.vue"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
    children: [
      {
        path: "",
        name: "login",
        component: () => import("@/components/user/LoginForm.vue"),
      },
      {
        path: "signup",
        name: "signup",
        component: () => import("@/components/user/SignupForm.vue"),
      },
    ],
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MyPage,
    children: [
      {
        path: "",
        name: "mypagemain",
        component: () => import("@/components/mypage/MyPageMain.vue"),
      },
      {
        path: "calendar",
        name: "calendar-view",
        component: () => import("@/components/mypage/CalendarView.vue"),
      },
      {
        path: "comment",
        name: "comment-list",
        component: () => import("@/components/mypage/CommentList.vue"),
      },
      {
        path: "likevideos",
        name: "like-videos",
        component: () => import("@/components/mypage/LikeVideos.vue"),
      },
      {
        path: "follow",
        name: "follow-view",
        component: () => import("@/components/mypage/FollowView.vue"),
      },
      {
        path: "myinfo",
        name: "my-info",
        component: () => import("@/components/mypage/MyInfo.vue"),
      },
      {
        path: "modifyform",
        name: "modify-form",
        component: () => import("@/components/mypage/MyInfo/ModifyForm.vue"),
      },
    ],
  },
  {
    path: "/guest",
    name: "guest",
    component: GuestPage,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
