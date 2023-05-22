<!-- 로그인 화면 -->
<template>
  <div class="container">
    <h2>Login</h2>
    <form action="">
      <div class="input-box">
        <input type="text" v-model="userId" placeholder="아이디" /><br />
      </div>
      <div class="input-box">
        <input
          type="password"
          v-model="password"
          placeholder="비밀번호"
        /><br />
      </div>
      <button @click="goLogIn">로그인</button><br />
      <router-link :to="{ name: 'signup' }">회원가입</router-link>
    </form>
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
    goLogIn() {
      const user = {
        userId: this.userId,
        password: this.password,
      };
      // console.log(user);
      this.$store.dispatch("userLogIn", user).then(() => {
        this.$router.push({ name: "video" });
      });
    },
  },
  computed: {},
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.input-box {
  position: relative;
  margin: 10px 0;
}
.input-box > input {
  background: transparent;
  border: none;
  border-bottom: solid 1px #ccc;
  padding: 20px 0px 5px 0px;
  font-size: 14pt;
  width: 100%;
}
</style>
