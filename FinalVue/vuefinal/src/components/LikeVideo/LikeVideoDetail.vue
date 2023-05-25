<template>
  <div class="text-content">
    <div @click="move">
      <div>
        <div class="img">
          <img :src="`${video.thumbnails}`" />
        </div>
        <div class="title">
          {{ video.title }}
        </div>
        <div class="channelName">
          {{ video.channelName }}
        </div>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "LikeVideoDetail",
  props: {
    info: Object,
  },
  data() {
    return {
      video: {},
      temp: {},
    };
  },
  created() {
    http
      .get(`/video/detail/${this.info.youtubeId}`)
      .then((res) => (this.video = res.data));
  },
  methods: {
    move() {
      http
        .get(`/video/detail/${this.info.youtubeId}`)
        .then((res) => {
          console.log(res.data);
          this.temp = res.data;
          console.log(this.temp);
        })
        .then(() => this.$store.dispatch("storeVideo", this.temp))
        .then(() => this.$store.dispatch("type", "like"))
        .then(() => this.$router.push({ name: "detail" }));
    },
  },
};
</script>

<style scoped>
.text-content {
  margin-top: 15px;
  height: 250px;
  text-align: center;
}
.text-content * {
  text-decoration: none;
}
img {
  height: 190px;
  width: 350px;
  object-fit: cover;
}
.title {
  margin-bottom: 5px;
  color: black;
  font-weight: bolder;
}
.channelName {
  margin-bottom: 5px;
  color: black;
}
</style>
