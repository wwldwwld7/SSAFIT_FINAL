<!-- 로그인 화면 -->
<template>
  <div>
    <input type="text" v-model="userId" placeholder="아이디" /><br />
    <input type="password" v-model="password" placeholder="비밀번호" /><br />
    <button @click="goLogIn">로그인</button><br />
    <router-link :to="{ name: 'signup' }">회원가입</router-link>
  </div>
</template>

<script>
// import {mapGetters} from "vuex";

export default {
  name: "LoginForm",
  data() {
    return {
      userId: "",
      password: "",
    };
  },
  methods: {
    async goLogIn() {
      const user = {
        userId: this.userId,
        password: this.password,
      };
      await this.$store.dispatch("userLogIn", user).then(() => {
        // this.$router.push({ name: "video" });
      });
    },
  },
  computed: {},
};
</script>

<style scoped></style>
