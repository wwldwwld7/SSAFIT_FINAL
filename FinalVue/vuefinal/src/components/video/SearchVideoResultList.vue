<template>
  <div class="text-content" @click="storeVideo(video)">
    <div class="img">
      <img :src="video.snippet.thumbnails.default.url" />
    </div>
    <div class="title">
      {{ title }}
    </div>
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
    return { title: "" };
  },
  methods: {
    storeVideo(value) {
      this.$store
        .dispatch("storeVideo", value)
        .then(() => this.$router.push({ name: "detail" }));
    },
  },
  created() {
    this.title = he.decode(this.video.snippet.title);
    console.log(this.video);
    console.log(this.title);
  },
};
</script>

<style>
.text-content {
  position: relative;
  height: 150px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.img {
  width: 300px;
  height: 150px;
  display: flex;
  align-items: center;
  justify-content: center;
}
img {
  width: 160px;
  height: 120px;
  object-fit: cover;
}
.title {
  margin: 0px 30px;
  width: 600px;
}
</style>
