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
      type: "",
      nickName: "",
      infos: [],
    };
  },
  computed: {
    ...mapGetters(["loginUser"]),
    ...mapGetters(["guestUser"]),
  },
  created() {
    this.type = this.$route.params.type;
    // console.log(this.type);
    // console.log(this.guestUser);
    if (this.type == "guest") {
      this.nickName = this.guestUser;
    } else {
      this.nickName = this.loginUser.nickName;
    }
    http.get(`/like/${this.nickName}`).then((res) => {
      this.infos = res.data;
    });
  },
};
</script>

<style></style>
