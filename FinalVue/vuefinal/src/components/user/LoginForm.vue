<!-- 로그인 화면 -->
<template>
  <div class="container">
    <form action="" method="post">
      <!-- id input -->
      <div class="input__block">
        <input
          type="text"
          v-model="userId"
          placeholder="아이디"
          class="input"
        />
      </div>
      <!-- password input -->
      <div class="input__block">
        <input
          type="password"
          v-model="password"
          placeholder="비밀번호"
          class="input"
        />
      </div>
      <!-- log in button -->
      <button class="signin__btn" @click="goLogIn">LOGIN</button><br />
      <router-link class="separator" :to="{ name: 'signup' }"
        >회원가입</router-link
      >
    </form>
  </div>
  <!-- 로그인폼 -->
  <!-- <div class="container">
    <h2>LOGIN</h2>
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
  </div> -->
</template>

<script>
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
      this.$store.dispatch("userLogIn", user).then(() => {
        // this.$router.push({ name: "video" }); //이렇게 주소 이동하니까 새로고침 해야됨
      });
    },
  },
  computed: {},
};
</script>

<style scoped>
/* body {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  background: white;
} */

.container {
  margin-top: 50px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  max-width: 60%;
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
}

form {
  padding: 60px 80px;
  width: 600px;
  display: inline-block;
}

form .input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}

form input {
  display: block;
  margin-bottom: 20px;
  border: 1px solid #e5e9f5;
  background-color: #f6f7fa;
  padding: 20px;
  margin-top: 10px;
  border-radius: 10px;
  width: 100%;
}
input::placeholder {
  color: #c0c7db;
}
form input:focus,
form input:active {
  outline: none;
  border: none;
  color: rgba(15, 19, 42, 1);
}

form .signin__btn {
  background: rgb(42, 42, 133);
  color: white;
  display: block;
  width: 100%;
  max-width: 600px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  cursor: pointer;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
  transition: 0.2s linear;
}

form .signin__btn:hover {
  box-shadow: 0 5px 30px rgb(185, 185, 250);
}
.separator {
  display: block;
  margin: 30px auto 10px;
  text-align: center;
  height: 40px;
  position: relative;
  background: transparent;
  color: #7369ab;
  /* font-size: 13px; */
  width: 90%;
  max-width: 680px;
  text-decoration: none;
}
</style>
