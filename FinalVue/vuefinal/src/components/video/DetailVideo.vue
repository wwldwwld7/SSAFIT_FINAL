<!-- 영상 상세 정보 화면 -->
<template>
  <div class="text-content">
    <iframe
      id="ytplayer"
      type="text/html"
      width="720"
      height="405"
      :src="`https://www.youtube.com/embed/${youtubeId}`"
      frameborder="0"
      allowfullscreen
    ></iframe
    ><br />
    <v-btn icon @click="liked" v-if="isShow">
      <v-icon style="color: red">mdi-heart</v-icon>
    </v-btn>
    <v-btn @click="unliked" v-if="!isShow">
      <v-icon style="color: black">mdi-heart-outline</v-icon>
    </v-btn>
    <div>채녈명 : {{ channelName }}<br /></div>
    <div>영상제목 : {{ title }}<br /></div>
    <!-- <img :src="`${thumbnails}`" /> -->
    <detail-video-comment :youtubeId="youtubeId"></detail-video-comment>
  </div>
</template>

<script>
import DetailVideoComment from "./DetailVideoComment.vue";
import http from "@/util/http-common";
import { mapState } from "vuex";
import he from "../../../node_modules/he/he";

export default {
  name: "DetailVideo",
  components: {
    DetailVideoComment,
  },
  computed: {
    ...mapState(["video"]),
    ...mapState(["loginUser"]),
  },
  data() {
    return {
      // video: this.video,
      youtubeId: "",
      channelName: "",
      title: "",
      thumbnails: "",
      videourl: "",
      isShow: false,
    };
  },
  async created() {
    this.youtubeId = this.video.id.videoId;
    this.channelName = this.video.snippet.channelTitle;
    this.title = he.decode(this.video.snippet.title);
    this.thumbnails = this.video.snippet.thumbnails.default.url;
    const video = {
      channelName: this.channelName,
      title: this.title,
      youtubeId: this.youtubeId,
      thumbnails: this.thumbnails,
    };

    //찜인지 아닌지 확인하기 위해
    http
      .get(`/like/start/${this.loginUser.nickName}/${this.youtubeId}`)
      .then(() => {
        this.isShow = true;
        console.log(this.isShow);
      })
      .catch(() => {
        this.isShow = false;
      });
    // 확인 끝 이거 위치 중요하니까 이 위치 옮기지 말아주세요 제발
    const a = await http.post(`/video/check/${this.youtubeId}`);
    if (a.status === 204) {
      http.post("/video", video);
    }
  },
  methods: {
    liked() {
      http
        .delete(`/like/${this.loginUser.nickName}/${this.youtubeId}`)
        .then(() => {
          this.isShow = false;
        });
    },
    unliked() {
      const follow = {
        nickName: this.loginUser.nickName,
        youtubeId: this.youtubeId,
      };
      http.post("/like", follow).then(() => {
        this.isShow = true;
      });
    },
  },
};
</script>

<style scoped>
.text-content {
  text-align: center;
}
</style>
