import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null, //로그인된 사람의 닉네임
    guestUser: null,
    userType: "",
    availableId: "", //아이디 중복체크
    availablenickName: "", //닉네임 중복체크
    video: {},
    type: "",
  },

  getters: {
    type(state) {
      return state.type;
    },
    userType(state) {
      return state.userType;
    },
    guestUser(state) {
      return state.guestUser;
    },
    loginUser(state) {
      return state.loginUser;
    },
    availableId(state) {
      return state.availableId;
    },
    availablenickName(state) {
      return state.availablenickName;
    },
  },
  mutations: {
    TYPE(state, type) {
      state.type = type;
    },
    MAKEUSERTYPE(state, type) {
      state.userType = type;
    },
    GUEST(state, payload) {
      state.guestUser = payload;
    },
    LOGIN(state, payload) {
      state.loginUser = payload;
    },
    DUPLICATEIDCHECK(state, payload) {
      state.availableId = payload;
    },
    DUPLICATENICKNAMECHECK(state, payload) {
      state.availablenickName = payload;
    },
    DOLOGOUT(state) {
      state.loginUser = null;
    },
    STOREVIDEO(state, video) {
      state.video = video;
    },
  },
  actions: {
    type(context, type) {
      context.commit("TYPE", type);
    },
    makeUserType(context, type) {
      context.commit("MAKEUSERTYPE", type);
    },
    guest(context, guest) {
      context.commit("GUEST", guest);
    },
    storeVideo(context, video) {
      context.commit("STOREVIDEO", video);
    },
    userLogIn({ commit }, user) {
      http
        .post("/user/login", user)
        .then(async (res) => {
          await commit("LOGIN", res.data);
          window.location.href = "http://localhost:8080/video";
        })
        .catch(() => {
          alert("로그인에 실패하였습니다.");
          window.location.href = "http://localhost:8080/user";
        });
    },
    duplicateIdCheck({ commit }, userId) {
      http
        .get(`/user/id_check/${userId}`)
        .then(({ data }) => {
          commit("DUPLICATEIDCHECK", data);
        })
        .catch(() => {
          commit("DUPLICATEIDCHECK", false);
        });
    },
    duplicateNickNameCheck({ commit }, nickName) {
      http
        .get(`/user//nickname_check/${nickName}`)
        .then(({ data }) => {
          commit("DUPLICATENICKNAMECHECK", data);
        })
        .catch(() => {
          commit("DUPLICATENICKNAMECHECK", false);
        });
    },
    doSignUp(context, user) {
      http.post("/user/signup", user).then(() => {
        window.location.href = "http://localhost:8080/user";
      });
    },
    doLogOut(context) {
      context.commit("DOLOGOUT");
    },
    doModify(context, user) {
      http.put("/user/modify", user).then(({ data }) => {
        console.log(data);
        context.commit("LOGIN", data);
        window.location.href = "http://localhost:8080/mypage/myinfo";
      });
    },
  },
  modules: {},
  plugins: [
    createPersistedState({
      paths: ["loginUser", "video", "guestUser", "userType", "type"], //여기에 쓴 state만 새로고침해도 저장되어있음
    }),
  ],
});
