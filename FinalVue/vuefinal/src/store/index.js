import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
import createPersistedState from "vuex-persistedstate";
// import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null, //로그인된 사람의 닉네임
    availableId: "", //아이디 중복체크
    availablenickName: "", //닉네임 중복체크
  },

  getters: {
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
    LOGIN(state, payload) {
      // state.loginUser = payload.nickName;
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
  },
  actions: {
    userLogIn({ commit }, user) {
      http
        .post("/user/login", user)
        .then((res) => {
          console.log(res);
          commit("LOGIN", res.data);
          // window.location.href = "http://localhost:8080/video";
        })
        .catch(() => {
          alert("로그인에 실패하였습니다.");
        });
    },
    duplicateIdCheck({ commit }, userId) {
      http
        .get(`/user/id_check/${userId}`)
        .then(({ data }) => {
          commit("DUPLICATEIDCHECK", data);
        })
        .catch(() => {
          commit("DUPLICATEIDCHECK", "");
        });
    },
    duplicateNickNameCheck({ commit }, nickName) {
      http
        .get(`/user//nickname_check/${nickName}`)
        .then(({ data }) => {
          commit("DUPLICATENICKNAMECHECK", data);
        })
        .catch(() => {
          commit("DUPLICATENICKNAMECHECK", "");
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
        context.commit("LOGIN", data);
        window.location.href = "http://localhost:8080/mypage/myinfo";
      });
    },
  },
  modules: {},
  plugins: [
    createPersistedState({
      paths: ["loginUser"], //여기에 쓴 state만 새로고침해도 저장되어있음
    }),
  ],
});
