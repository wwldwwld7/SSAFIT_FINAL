<template>
  <div>
    <ul>
      <li v-for="(video, index) in videos" :key="index">
        <img @click="CaR" :src="video.snippet.thumbnails.default.url" />
        {{ video.snippet.title }}
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
  data() {
    return {
      video: {},
    };
  },
  methods: {
    CaR() {
      //   const youtubeId = this.videos[index];
      console.log(this.videos[this.key]);
    },
  },
};
</script>

<style></style>
