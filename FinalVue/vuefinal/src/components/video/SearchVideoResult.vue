<template>
  <div>
    <ul>
      <li v-for="(video, index) in videos" :key="index">
        <img :src="video.snippet.thumbnails.default.url" />
        {{ video.snippet.title }}
        <!-- <detail-video :video="video"></detail-video> -->
        <router-link :to="{ name: 'detail', params: { video: video } }">
          상세보기</router-link
        >
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "SearchVideoResult",
  props: {
    videos: Array,
  },
  components: {},
  data() {
    return {
      video: {},
    };
  },
  methods: {},
};
</script>

<style></style>
