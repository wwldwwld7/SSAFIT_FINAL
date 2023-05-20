<template>
  <div>
    <search-video @search-input="search"></search-video>
    <div>
      <search-video-result :videos="videos"></search-video-result>
      <router-view />
    </div>
  </div>
</template>

<script>
import SearchVideo from "@/components/video/SearchVideo.vue";
import SearchVideoResult from "@/components/video/SearchVideoResult.vue";
import axios from "axios";

export default {
  name: "VideoView",
  components: {
    SearchVideo,
    SearchVideoResult,
  },
  data() {
    return {
      //created든 수동적으로 넣든 json으로 기본 영상정보 넣어주기.
      videos: [],
      video: {},
    };
  },
  methods: {
    search(value) {
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;
      axios({
        url: URL,
        method: "GET",
        params: {
          key: API_KEY,
          part: "snippet",
          q: value,
          type: "video",
          maxResults: 5,
        },
      })
        .then((res) => {
          console.log(res);
          return res.data.items;
        })
        .then((res) => {
          this.videos = res;
        });
      // .catch((err) => console.log(err));
    },
  },
};
</script>

<style></style>
