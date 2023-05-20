<!-- 회원 가입 화면 -->
<template>
  <div>
    <input type="text" v-model="userId" placeholder="아이디 입력" />
    <button>중복확인</button><br />
    <input type="text" placeholder="이름 입력" /><br />
    <input type="password" placeholder="비밀번호 입력" /><br />
    <input type="password" placeholder="비밀번호 확인" /><br />
    <input type="text" placeholder="닉네임 입력" />
    <button>중복확인</button><br />
    <button>회원가입</button><br />
  </div>
</template>

<script>
export default {
  name: "SignupForm",
  data() {
    return {
      userId: "",
      password: "",
      nickName: "",
    };
  },
};
</script>

<style></style>
