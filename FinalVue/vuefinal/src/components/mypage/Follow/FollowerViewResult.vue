<template>
  <div>
    <div v-if="loginedUser === nickName">
      <div class="box">
        <div class="nickName">
          <router-link
            :to="{ name: 'mypagemain', params: { nickName: nickName } }"
          >
            {{ nickName }}
          </router-link>
        </div>
        <div class="msg">
          {{ stateMsg }}
        </div>
      </div>
    </div>
    <div v-if="loginedUser !== nickName">
      <div class="box">
        <div class="nickName">
          <router-link :to="{ name: 'guest', params: { nickName: nickName } }">
            {{ nickName }}
          </router-link>
        </div>
        <div class="msg">
          {{ stateMsg }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "FollowerViewResult",
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
.box {
  margin: 7px 0px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.nickName {
  width: 50px;
}
.msg {
  width: 250px;
}
.nickName > a {
  color: black;
  text-decoration: none;
}
</style>
