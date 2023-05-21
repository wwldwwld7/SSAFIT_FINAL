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
    <button>찜</button>
    <div>채녈명 : {{ channelName }}<br /></div>
    <div>영상제목 : {{ title }}<br /></div>
    <!-- <img :src="`${thumbnails}`" /> -->
    <detail-video-comment :youtubeId="youtubeId"></detail-video-comment>
  </div>
</template>

<script>
import DetailVideoComment from "./DetailVideoComment.vue";
import http from "@/util/http-common";

export default {
  name: "DetailVideo",
  components: {
    DetailVideoComment,
  },
  data() {
    return {
      video: this.$route.params.video,
      youtubeId: "",
      channelName: "",
      title: "",
      thumbnails: "",
      videourl: "",
    };
  },
  async created() {
    this.youtubeId = this.video.id.videoId;
    this.channelName = this.video.snippet.channelTitle;
    this.title = this.video.snippet.title;
    this.thumbnails = this.video.snippet.thumbnails.default.url;
    const video = {
      channelName: this.channelName,
      title: this.title,
      youtubeId: this.youtubeId,
      thumbnails: this.thumbnails,
    };
    console.log(this.youtubeId);
    const a = await http.post(`/video/check/${this.youtubeId}`);
    if (a.status === 204) {
      http.post("/video", video);
    }
  },
};
</script>

<style scoped>
.text-content {
  text-align: center;
}
</style>
