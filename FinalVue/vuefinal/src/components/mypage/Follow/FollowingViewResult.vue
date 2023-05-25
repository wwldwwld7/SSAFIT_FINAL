<template>
  <div class="container">
    <div v-if="loginedUser === nickName">
      <router-link
        class="nickname"
        :to="{ name: 'mypagemain', params: { nickName: nickName } }"
      >
        {{ nickName }}
      </router-link>
      {{ stateMsg }}
    </div>
    <div v-if="loginedUser !== nickName">
      <router-link
        class="msg"
        :to="{ name: 'guest', params: { nickName: nickName } }"
      >
        {{ nickName }}
      </router-link>
      {{ stateMsg }}
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "FollowingViewResult",
  props: {
    info: Object,
  },
  data() {
    return {
      nickName: "",
      stateMsg: "",
      loginedUser: "",
    };
  },
  computed: {
    ...mapGetters(["loginUser"]),
  },
  created() {
    this.loginedUser = this.loginUser.nickName;
    this.nickName = this.info.nickName;
    this.stateMsg = this.info.stateMsg;
  },
};
</script>

<style scoped>
.container {
  display: block;
}
.nickname,
.msg {
  text-decoration: none;
}
.nickname {
  width: 100px;
  text-align: left;
  /* text-align: left; */
  /* float: left; */
}
.msg {
  width: 200px;
}
</style>
