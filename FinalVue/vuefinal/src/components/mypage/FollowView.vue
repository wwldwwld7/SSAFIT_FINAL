<!-- 팔로워 / 팔로잉 화면 -->
<template>
  <div>
    <following-view :followList="followList"></following-view>
    <follower-view :followedList="followedList"></follower-view>
  </div>
</template>

<script>
import FollowerView from "@/components/mypage/Follow/FollowerView.vue";
import FollowingView from "@/components/mypage/Follow/FollowingView.vue";
import http from "@/util/http-common";
import { mapGetters } from "vuex";

export default {
  name: "FollowView",
  components: {
    FollowerView,
    FollowingView,
  },
  data() {
    return {
      type: "",
      nickName: "",
      followList: [],
      followedList: [],
    };
  },
  computed: {
    ...mapGetters(["loginUser"]),
    ...mapGetters(["guestUser"]),
  },
  created() {
    this.type = this.$route.params.type;
    if (this.type === "user") {
      this.nickName = this.loginUser.nickName;
    } else {
      this.nickName = this.guestUser;
    }
    http.get(`/follow/to/${this.nickName}`).then((res) => {
      console.log(res);
      this.followList = res.data;
    });
    http.get(`/follow/from/${this.nickName}`).then((res) => {
      this.followedList = res.data;
    });
  },
};
</script>

<style></style>
