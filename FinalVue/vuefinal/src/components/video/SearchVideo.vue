<template>
  <div>
    <div class="text-content">
      <div class="search">
        <input
          class="inputbox"
          type="text"
          v-model="keyword"
          @keyup.enter="search(keyword)"
        />
        <button class="btn" @click="search(keyword)">
          <v-icon class="search-icon">mdi-magnify</v-icon>
        </button>
      </div>
    </div>
    <search-video-result :videos="videos"></search-video-result>
  </div>
</template>

<script>
import SearchVideoResult from "./SearchVideoResult.vue";
import axios from "axios";
import http from "@/util/http-common.js";

export default {
  components: {
    SearchVideoResult,
  },
  name: "SearchVideo",
  data() {
    return {
      keyword: "",
      videos: [],
      saved: [],
    };
  },
  created() {
    http.get("/video").then(({ data }) => {
      this.saved = data;
    });
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

<style scoped>
.text-content {
  margin-top: 50px;
  position: relative;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  /* margin-bottom: 300px; */
}
.search {
  width: 500px;
  height: 50px;
  background-color: #e5e9f5;
  font-style: sans-serif;
  border-radius: 5px;
  display: flex;
  align-items: center;
}
.search-icon {
  margin-left: 13px;
}
.inputbox {
  text-indent: 2%;
  width: 450px;
}
.inputbox:focus {
  outline: none;
}
.btn {
  float: right;
  width: 48px;
  height: 30px;
  background-color: #e5e9f5;
  color: black;
  border-radius: 5px;
  font-weight: bolder;
  margin-right: 13px;
}
</style>
