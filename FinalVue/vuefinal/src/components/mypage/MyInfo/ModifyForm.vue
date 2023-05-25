<template>
  <div class="container">
    <div class="modify-container">
      <div class="item">
        <label for="name">이름</label>
        <input
          type="text"
          id="name"
          v-model="name"
          readonly
          style="color: #838897"
        />
      </div>
      <div class="item">
        <label for="userId">아이디</label>
        <input
          type="text"
          id="userId"
          v-model="userId"
          readonly
          style="color: #838897"
        />
      </div>
      <div class="item">
        <label for="nickName">닉네임</label>
        <input
          type="text"
          id="nickName"
          v-model="nickName"
          readonly
          style="color: #838897"
        />
      </div>
      <div class="item">
        <label for="stateMsg">상태 메세지</label>
        <input type="text" id="stateMsg" v-model="stateMsg" />
      </div>
      <div class="item">
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="password" />
      </div>
      <div class="item">
        <label for="password">비밀번호 확인</label>
        <input
          type="password"
          id="password"
          v-model="passwordCheck"
          @keyup="pwCheck"
        /><br />
      </div>
      <span v-show="passwordCheck" v-if="passwordCheckFlag"
        >비밀번호가 일치합니다.</span
      ><br />
      <button @click="modifyInfo">수정</button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "ModifyForm",
  computed: {
    ...mapGetters(["loginUser"]),
  },
  data() {
    return {
      name: "",
      userId: "",
      nickName: "",
      stateMsg: "",
      password: "",
      passwordCheck: "",
      passwordCheckFlag: false,
    };
  },
  created() {
    this.name = this.loginUser.name;
    this.userId = this.loginUser.userId;
    this.nickName = this.loginUser.nickName;
    this.stateMsg = this.loginUser.stateMsg;
  },
  methods: {
    pwCheck() {
      if (this.password === this.passwordCheck) {
        this.passwordCheckFlag = true;
      }
    },
    modifyInfo() {
      const user = {
        name: this.name,
        userId: this.userId,
        nickName: this.nickName,
        password: this.password,
        stateMsg: this.stateMsg,
      };
      if (this.passwordCheckFlag) {
        this.$store.dispatch("doModify", user).then(() => {
          console.log(this.loginUser);
          this.$router.push({ name: "my-info" });
        });
      } else {
        alert("잘못된 정보가 입력되었습니다.");
      }
    },
  },
};
</script>

<style scoped>
.container {
  display: block;
  max-width: 600px;
  margin: auto;
  margin-top: 50px;
  margin-bottom: 50px;
  background-color: white;
  max-width: 60%;
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
  display: flex;
  justify-content: center;
  align-items: center;
}
.modify-container {
  padding: 60px 80px;
  width: 680px;
  max-width: 100%;
  display: inline-block;
}
label {
  color: #7369ab;
  display: inline-block;
  width: 130px;
}
div input {
  display: block;
  margin-bottom: 20px;
  border: 1px solid #e5e9f5;
  background-color: #f6f7fa;
  padding: 20px;
  margin-top: 10px;
  border-radius: 10px;
  width: 100%;
  outline: none;
}
.item {
  display: inline-block;
  display: flex;
  align-items: center;
}
span {
  display: block;
  margin-top: 10px;
  color: blue;
}
button {
  padding: 16px 50px;
  background-color: rgb(42, 42, 133);
  border-radius: 10px;
  color: white;
}
button:hover {
  box-shadow: 0 5px 30px rgb(185, 185, 250);
}
</style>
