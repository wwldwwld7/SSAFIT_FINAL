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

export default {
  name: "FollowView",
  components: {
    FollowerView,
    FollowingView,
  },
  data() {
    return {
      nickName: "",
      followList: [],
      followedList: [],
    };
  },
  created() {
    this.nickName = this.$route.params.nickName;
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
