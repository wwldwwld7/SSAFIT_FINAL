<!-- 회원 정보 수정 화면 -->
<template>
  <div>
    <div>
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" readonly /><br />
      <label for="userId">아이디</label>
      <input type="text" id="userId" v-model="userId" readonly /><br />
      <label for="nickName">닉네임</label>
      <input type="text" id="nickName" v-model="nickName" readonly /><br />
      <label for="stateMsg">상태 메세지</label>
      <input type="text" id="stateMsg" v-model="stateMsg" /><br />
      <label for="password">비밀번호</label>
      <input type="password" id="password" v-model="password" /><br />
      <label for="password">비밀번호 확인</label>
      <input
        type="password"
        id="password"
        v-model="passwordCheck"
        @keyup="pwCheck"
      /><br />
      <span v-if="passwordCheckFlag">비밀번호가 일치합니다.</span><br />
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
    this.userId = this.loginUser.id;
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
          this.$router.push({ name: "my-info" });
        });
      } else {
        alert("잘못된 정보가 입력되었습니다.");
      }
    },
  },
};
</script>

<style></style>
