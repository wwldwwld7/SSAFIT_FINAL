<!-- 영상 상세 정보 화면 -->
<template>
  <div>
    <detail-video-comment></detail-video-comment>
    {{ youtubeId }}<br />
    {{ channelName }}<br />
    {{ title }}
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
  // props: {
  //   video: Object,
  // },
  data() {
    return {
      video: this.$route.params.video,
      youtubeId: "",
      channelName: "",
      title: "",
    };
  },
  async created() {
    this.youtubeId = this.video.id.videoId;
    this.channelName = this.video.snippet.channelTitle;
    this.title = this.video.snippet.title;
    // console.log(.video);
    // console.log(.video.youtubeId);
    // console.log(this.video.channelName);
    // console.log(this.video.title);
    const video = {
      channelName: this.channelName,
      title: this.title,
      // viewCnt: 2,
      youtubeId: this.youtubeId,
    };
    // http.post("/video", {
    //   channelName: this.channelName,
    //   title: this.title,
    //   viewCnt: 2,
    //   youtubeId: this.youtubeId,
    // });
    console.log(this.youtubeId);
    const a = await http.post(`/video/check/${this.youtubeId}`);
    console.log(a.status);
    // console(http.post("/video/check", `${this.youtubeId}`).data);
    if (a.status === 204) {
      http.post("/video", video);
    }
  },
};
</script>

<style></style>
