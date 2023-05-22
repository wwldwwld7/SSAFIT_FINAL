<template>
  <div>
    <ul>
      <li v-for="(video, index) in videos" :key="index">
        <search-video-result-list :video="video"></search-video-result-list>

        <!-- <img :src="video.snippet.thumbnails.default.url" />
        {{ video.snippet.title }}
        <router-link
          @click.native="storeVideo(video)"
          :to="{ name: 'detail', params: { video: video } }"
        >
          상세보기</router-link
        > -->
      </li>
    </ul>
  </div>
</template>

<script>
import SearchVideoResultList from "./SearchVideoResultList.vue";
// import he from "../../../node_modules/he/he";

export default {
  name: "SearchVideoResult",
  props: {
    videos: Array,
  },
  components: { SearchVideoResultList },
  data() {
    return {
      // video: {},
    };
  },
  methods: {
    storeVideo(value) {
      this.$store.dispatch("storeVideo", value);
    },
  },
};
</script>

<style></style>
