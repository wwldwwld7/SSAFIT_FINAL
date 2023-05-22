import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import VideoView from "../views/VideoView.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import MyPage from "../views/MyPage.vue";
import SignupForm from "@/components/user/SignupForm.vue";
import MyPageMain from "@/components/mypage/MyPageMain.vue";
import CalendarView from "@/components/mypage/CalendarView.vue";
import CommentList from "@/components/mypage/CommentList.vue";
import LikeVideos from "@/components/mypage/LikeVideos.vue";
import FollowView from "@/components/mypage/FollowView.vue";
import MyInfo from "@/components/mypage/MyInfo.vue";

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
        component: LoginForm,
      },
      {
        path: "signup",
        name: "signup",
        component: SignupForm,
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
        component: MyPageMain,
      },
      {
        path: "calendar",
        name: "calendar-view",
        component: CalendarView,
      },
      {
        path: "comment",
        name: "comment-list",
        component: CommentList,
      },
      {
        path: "likevideos",
        name: "like-videos",
        component: LikeVideos,
      },
      {
        path: "follow",
        name: "follow-view",
        component: FollowView,
      },
      {
        path: "myinfo",
        name: "my-info",
        component: MyInfo,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
