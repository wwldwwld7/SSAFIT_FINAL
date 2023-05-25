<template>
  <div class="container">
    <div class="title">
      <h3>{{ this.nickName }}</h3>
      님의 찜 영상
    </div>
    <ul>
      <div v-for="(info, index) in infos" :key="index">
        <like-video-detail :info="info"></like-video-detail>
      </div>
    </ul>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import http from "@/util/http-common";
import LikeVideoDetail from "@/components/LikeVideo/LikeVideoDetail.vue";

export default {
  name: "LikeVideos",
  components: {
    LikeVideoDetail,
  },
  data() {
    return {
      type: "",
      nickName: "",
      infos: [],
      temp: "< 찜한 영상 ~ >",
    };
  },
  computed: {
    ...mapGetters(["loginUser", "guestUser", "userType"]),
  },
  created() {
    console.log(this.userType);
    this.type = this.userType;
    if (this.type == "user") {
      this.nickName = this.loginUser.nickName;
    } else {
      this.nickName = this.guestUser;
    }
    http.get(`/like/${this.nickName}`).then((res) => {
      this.infos = res.data;
    });
  },
};
</script>

<style scoped>
.container {
  text-align: center;
  width: 1000px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
h1 {
  text-align: center;
}
.title {
  margin-top: 50px;
  margin-bottom: 50px;
  display: inline-flex;
}
</style>
