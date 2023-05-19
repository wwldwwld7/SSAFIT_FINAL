import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
// import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null,
  },

  getters: {},
  mutations: {
    LOGIN(state, payload) {
      console.log(payload);
      state.loginUser = payload;
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
        .then((res) => {
          console.log(res.config);
          console.log(res.config.data);
          commit("LOGIN", res.config.data);
          console.log(this.state.loginUser);
        })
        .catch(() => {
          alert("로그인에 실패하였습니다.");
        });
    },
  },
  modules: {},
});
