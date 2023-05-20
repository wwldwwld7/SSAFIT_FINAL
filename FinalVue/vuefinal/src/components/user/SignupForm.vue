<!-- 회원 가입 화면 -->
<template>
  <div>
    <input type="text" v-model="userId" placeholder="아이디 입력" />
    <button @click="duplicateIdCheck">중복확인</button><br />
    <span v-if="userId" v-show="availableId">사용 가능한 아이디 입니다.</span>
    <span v-if="userId" v-show="!availableId">중복된 아이디 입니다.</span><br />
    <input type="text" v-model="name" placeholder="이름 입력" /><br />
    <input
      type="password"
      v-model="password"
      placeholder="비밀번호 입력"
    /><br />
    <input
      type="password"
      v-model="passwordCheck"
      @keyup="pwCheck"
      placeholder="비밀번호 확인"
    /><br />
    <span v-if="!passwordCheckFlag">비밀번호가 일치하지 않습니다.</span>
    <span v-if="passwordCheckFlag">비밀번호가 일치합니다.</span><br />
    <input type="text" v-model="nickName" placeholder="닉네임 입력" />
    <button @click="duplicateNickNameCheck">중복확인</button><br />
    <span v-if="nickName" v-show="availablenickName"
      >사용 가능한 닉네임 입니다.</span
    >
    <span v-if="nickName" v-show="!availablenickName"
      >중복된 닉네임 입니다.</span
    ><br />
    <button @click="doSignUp">회원가입</button><br />
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "SignupForm",
  data() {
    return {
      userId: "",
      name: "",
      password: "",
      nickName: "",
      passwordCheck: "",
      // idCheck: false,
      // passwordCheck: false,
      // nickNameCheck: fasle,
      passwordCheckFlag: false,
    };
  },
  methods: {
    duplicateIdCheck() {
      this.$store.dispatch("duplicateIdCheck", this.userId);
      // console.log(this.availableId);
      // if (this.availableId) {
      //   this.idCheck = true;
    },
    duplicateNickNameCheck() {
      this.$store.dispatch("duplicateNickNameCheck", this.nickName);
    },
    pwCheck() {
      if (this.password === this.passwordCheck) {
        this.passwordCheckFlag = true;
      }
    },
    doSignUp() {
      const user = {
        userId: this.userId,
        name: this.name,
        password: this.password,
        nickName: this.nickName,
      };
      if (
        this.availableId &&
        this.passwordCheckFlag &&
        this.duplicateNickNameCheck
      ) {
        this.$store.dispatch("doSignUp", user);
      }
    },
  },
  computed: {
    ...mapGetters(["availableId"]),
    ...mapGetters(["availablenickName"]),
  },
};
</script>

<style></style>
