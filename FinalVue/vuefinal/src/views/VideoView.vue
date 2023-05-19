<template>
  <div>
    <h2>영상보여주는 페이지</h2>
    <search-video @search-input="search"></search-video>
  </div>
</template>

<script>
import SearchVideo from "@/components/video/SearchVideo.vue";
import axios from "axios";

export default {
  name: "VideoView",
  components: {
    SearchVideo,
  },
  methods: {
    search(value) {
      const URL = "https://www.googleapis.com/youtube/v3/search";
      axios({
        url: URL,
        method: "GET",
        params: {
          key: process.env.API_Key,
          part: "snippet",
          q: value,
          type: "video",
          maxResult: 20,
        },
      }).then((res) => {
        console.log(res);
      });
    },
  },
};
</script>

<style></style>
