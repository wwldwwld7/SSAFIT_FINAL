<template>
  <div id="container">
    <div id="sign-up-container">
      <div>
        <label for="id">아이디</label>
        <div class="check">
          <input type="text" v-model="userId" name="id" id="name" />
          <button class="dbtn" @click="duplicateIdCheck">중복확인</button>
        </div>
        <span v-if="userId" v-show="availableId" style="color: blue"
          >사용 가능한 아이디 입니다.</span
        >
        <span v-if="userId" v-show="!availableId" style="color: red"
          >중복된 아이디 입니다.</span
        ><br />

        <label for="name">이름</label>
        <input type="text" v-model="name" name="name" id="name" />

        <label for="nickname">닉네임</label>
        <div class="check">
          <input type="text" v-model="nickName" name="nickname" id="nickname" />
          <button class="dbtn" @click="duplicateNickNameCheck">중복확인</button>
        </div>
        <span v-if="nickName" v-show="availablenickName" style="color: blue"
          >사용 가능한 닉네임 입니다.</span
        >
        <span v-if="nickName" v-show="!availablenickName" style="color: red"
          >중복된 닉네임 입니다.</span
        ><br />

        <label for="password">비밀번호</label>
        <input
          type="password"
          v-model="password"
          name="password"
          id="password"
        />
        <label for="password">비밀번호 확인</label>
        <input
          type="password"
          v-model="passwordCheck"
          @keyup="pwCheck"
          name="password"
          id="password"
        />
        <span v-if="!passwordCheckFlag" style="color: red"
          >비밀번호가 일치하지 않습니다.</span
        >
        <span v-if="passwordCheckFlag" style="color: blue"
          >비밀번호가 일치합니다.</span
        ><br />

        <div id="form-controls">
          <button class="signup-btn" @click="doSignUp">회원가입</button>
        </div>
      </div>
    </div>
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
      stateMsg: "",
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
        stateMsg: this.stateMsg,
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

<style scoped>
body {
  background-color: #f3f4f9;
  margin: 0;
  padding: 0;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
#container {
  display: block;
  max-width: 600px;
  margin: auto;
  margin-bottom: 50px;
  background-color: white;
  max-width: 60%;
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
  display: flex;
  justify-content: center;
  align-items: center;
}

#sign-up-container,
#sign-in-container {
  padding: 60px 80px;
  width: 600px;
  display: inline-block;
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

#form-controls {
  margin-bottom: 20px;
}

label {
  color: #7369ab;
}

::placeholder {
  color: #c0c7db;
  font-size: larger;
  letter-spacing: 1.2px;
}
.signup-btn {
  padding: 16px 75px;
  background-color: navy;
  border-radius: 10px;
  color: white;
}
.check {
  display: flex;
}
.dbtn {
  background-color: #c0c7db;
  color: #7369ab;
  /* margin: 0; */
  padding: 0px 15px;
  font-size: 14px;
  border-radius: 10px;
  margin-top: 10px;
  margin-bottom: 20px;
  margin-left: 5px;
  white-space: nowrap;
}
</style>
