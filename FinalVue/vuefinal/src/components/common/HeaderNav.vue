<template>
  <div>
    헤더야~
    <router-link :to="{ name: 'video' }"> 비디오 </router-link>
    <router-link v-if="!loginUser" to="/user"> 로그인 </router-link>
    <router-link v-if="loginUser" to="/mypage">
      {{ loginUser.nickName }}님 환영합니다.
    </router-link>
    <button v-if="loginUser" @click="doLogOut">로그아웃</button>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "HeaderNav",
  computed: {
    ...mapGetters(["loginUser"]),
  },
  methods: {
    doLogOut() {
      this.$store.dispatch("doLogOut").then(() => {
        this.$router.push("/");
      });
    },
  },
};
</script>

<style></style>
