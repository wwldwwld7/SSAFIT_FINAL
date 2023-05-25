<!-- 영상 상세 정보 화면 -->
<template>
  <div>
    <div class="videobox">
      <iframe
        id="ytplayer"
        type="text/html"
        width="720"
        height="405"
        :src="`https://www.youtube.com/embed/${youtubeId}`"
        frameborder="0"
        allowfullscreen
      ></iframe>
    </div>
    <div class="text-content1">
      <div>
        <v-btn icon @click="liked" v-if="isShow">
          <v-icon style="color: red">mdi-heart</v-icon>
        </v-btn>
        <v-btn icon @click="unliked" v-if="!isShow">
          <v-icon style="color: black">mdi-heart-outline</v-icon>
        </v-btn>
      </div>
      <div>
        <div>채녈명 : {{ channelName }}</div>
      </div>
      <div>
        <div>영상제목 : {{ title }}</div>
      </div>
      <div>
        <detail-video-comment :youtubeId="youtubeId"></detail-video-comment>
      </div>
    </div>
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
    ...mapState(["type"]),
  },
  data() {
    return {
      youtubeId: "",
      channelName: "",
      title: "",
      thumbnails: "",
      videourl: "",
      isShow: false,
    };
  },
  async created() {
    console.log(this.type);
    console.log(this.video);
    if (this.type === "like") {
      this.youtubeId = this.video.youtubeId;
      this.channelName = this.video.channelName;
      this.title = this.video.title;
      this.thumbnails = this.video.thumbnails;
      this.videourl = this.video.videourl;
    } else if (this.type === "search") {
      this.youtubeId = this.video.id.videoId;
      this.channelName = this.video.snippet.channelTitle;
      this.title = he
        .decode(this.video.snippet.title)
        .replace(/[\uD800-\uDBFF][\uDC00-\uDFFF]/g, "");
      this.thumbnails = this.video.snippet.thumbnails.default.url;
    }
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
.videobox {
  margin-top: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}
.text-content1 * {
  text-align: center;
  margin-bottom: 10px;
}
</style>
