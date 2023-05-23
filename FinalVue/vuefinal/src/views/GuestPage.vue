<template>
  <div>
    <div v-if="followflag">
      <button @click="unfollow">Following</button>
    </div>
    <div v-if="!followflag">
      <button @click="follow">Follow</button>
    </div>

    <div>
      <router-link :to="{ name: 'calendar-view' }">캘린더</router-link>
    </div>
    <div>
      <router-link :to="{ name: 'like-videos' }">찜 목록</router-link>
    </div>
    <div>
      <router-link :to="{ name: 'follow-view', params: { nickName: nickName } }"
        >팔로워/팔로잉</router-link
      >
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import http from "@/util/http-common";

export default {
  name: "GuestPage",
  data() {
    return {
      nickName: "",
      followflag: "",
    };
  },
  methods: {
    unfollow() {
      http
        .delete(`/follow/${this.loginUser.nickName}/${this.nickName}`)
        .then(() => (this.followflag = !this.followflag));
      // .then(() => this.$router.go(0));
    },
    follow() {
      const follow = {
        follower: this.loginUser.nickName,
        following: this.nickName,
      };
      http
        .post("/follow", follow)
        .then(() => (this.followflag = !this.followflag));
    },
  },
  computed: {
    ...mapGetters(["loginUser"]),
  },
  created() {
    this.nickName = this.$route.params.nickName;
    console.log(this.loginUser.nickName);
    console.log(this.nickName);
    http
      .get(`/follow/${this.loginUser.nickName}/${this.nickName}`)
      .then((res) => {
        console.log(res);
        if (res.status == 204) {
          this.followflag = false;
        } else {
          this.followflag = true;
        }
      });
  },
};
</script>

<style></style>
