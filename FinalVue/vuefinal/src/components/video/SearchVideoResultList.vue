<template>
  <div>
    <img :src="video.snippet.thumbnails.default.url" />
    {{ title }}
    <button @click="storeVideo(video)">상세 보기</button>
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
      this.$store
        .dispatch("storeVideo", value)
        .then(() => this.$router.push({ name: "detail" }));
    },
  },
};
</script>

<style></style>
