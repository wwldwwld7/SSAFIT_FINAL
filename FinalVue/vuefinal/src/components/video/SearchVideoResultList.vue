<template>
  <div>
    <img :src="video.snippet.thumbnails.default.url" />
    {{ title }}
    <router-link
      @click.native="storeVideo(video)"
      :to="{ name: 'detail', params: { video: video } }"
    >
      상세보기</router-link
    >
  </div>
</template>

<script>
import he from "../../../node_modules/he/he";
export default {
  name: "SearchVideoResultList",
  props: {
    video: Object,
  },
  data() {
    return { title: he.decode(this.video.snippet.title) };
  },
  methods: {
    storeVideo(value) {
      this.$store.dispatch("storeVideo", value);
    },
  },
};
</script>

<style></style>
