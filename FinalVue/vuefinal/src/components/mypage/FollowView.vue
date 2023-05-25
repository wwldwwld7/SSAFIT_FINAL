<!-- 팔로워 / 팔로잉 화면 -->
<template>
  <div class="container">
    <div class="title">
      <h3>{{ this.nickName }}</h3>
      님의 follow list
    </div>
    <div class="list">
      <div class="list-following">
        <label for="" class="following">Following</label>
        <following-view
          class="list-item"
          :followList="followList"
        ></following-view>
      </div>
      <div class="list-follower">
        <label for="" class="follower">Follower</label>
        <follower-view
          class="list-item"
          :followedList="followedList"
        ></follower-view>
      </div>
    </div>
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
    ...mapGetters(["loginUser", "guestUser", "userType"]),
    // ...mapGetters(["guestUser"]),
  },
  created() {
    this.type = this.userType;
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

<style scoped>
.container {
  text-align: center;
  /* width: 1000px; */
  /* height: auto; */
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.title {
  margin-top: 50px;
  margin-bottom: 50px;
  display: inline-flex;
  /* display: inline-block; */
}
.list {
  display: flex;
  justify-content: center;
}
.list div {
  display: inline-block;
  /* float: left; */
  /* align-content: center; */
  /* text-align: center; */
  width: 300px;
  height: auto;
  height: 500px;
  margin-right: 30px;
  border-radius: 8px;
  /* background-color: #f6f7fa; */
}
.list-following,
.list-follower {
  /* margin: auto; */
}
label {
  float: left;
}
.following {
  padding: 5px 10px;
  background: blue;
  color: white;
  font-style: bold;
  border-radius: 15px;
}
.follower {
  padding: 5px 10px;
  background: red;
  color: white;
  font-style: bold;
  border-radius: 15px;
}
.list-item {
  background-color: #f6f7fa;
  width: 400px;
  list-style: none;
}
</style>
