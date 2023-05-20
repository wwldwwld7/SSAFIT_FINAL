import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
// import Router from "next/router";
// import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null,
    availableId: "",
    availablenickName: "",
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
      // console.log(payload);
      state.loginUser = payload;
    },
    DUPLICATEIDCHECK(state, payload) {
      state.availableId = payload;
    },
    DUPLICATENICKNAMECHECK(state, payload) {
      state.availablenickName = payload;
    },
  },
  actions: {
    userLogIn({ commit }, user) {
      // axios({
      //   url: `http://localhost:9999/user/login`,
      //   method: "POST",
      //   params: user,
      // })
      //   .then((res) => {
      //     console.log(res);
      //     commit("LOGIN", res);
      //     // this.$router.push({ name: "video" });
      //   })
      //   .catch((err) => {
      //     console.log(err);
      //     alert("로그인에 실패하였습니다.");
      //   });

      http
        .post("/user/login", user)
        // .then(({ data }) => {
        //   console.log(data);
        //   commit("LOGIN", data);
        // })
        .then((res) => {
          console.log(res);
          commit("LOGIN", res.data);
          window.location.href = "http://localhost:8080/video";
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
  },
  modules: {},
});
