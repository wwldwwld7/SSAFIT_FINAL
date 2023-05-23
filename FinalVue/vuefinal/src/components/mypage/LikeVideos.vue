<!-- 찜한 영상 화면 -->
<template>
  <div>
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
      infos: [],
    };
  },
  computed: {
    ...mapGetters(["loginUser"]),
  },
  created() {
    http
      .get(`/like/${this.loginUser.nickName}`)
      .then((res) => (this.infos = res.data));
  },
};
</script>

<style></style>
