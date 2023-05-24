<!-- 찜한 영상 화면 -->
<template>
  <div>
    <h1>{{ temp }}</h1>
    <ul>
      <li v-for="(info, index) in infos" :key="index">
        <like-video-detail :info="info"></like-video-detail>
      </li>
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
    http.get(`/like/${this.nickName}`).then((res) => (this.infos = res.data));
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
}
</style>
