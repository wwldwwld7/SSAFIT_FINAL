<!-- 영상 메인화면 ( 검색창 + 검색 결과에 따른 영상 리스트) -->
<template>
  <div>
    <input type="text" v-model="keyword" />
    <button @click="search(keyword)">검색</button>
    <search-video-result :videos="videos"></search-video-result>
  </div>
</template>

<script>
import SearchVideoResult from "./SearchVideoResult.vue";
import axios from "axios";

export default {
  components: {
    SearchVideoResult,
  },
  name: "SearchVideo",
  data() {
    return {
      keyword: "",
      videos: [],
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
          maxResults: 3,
        },
      })
        .then((res) => {
          return res.data.items;
        })
        .then((res) => {
          this.videos = res;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style></style>
