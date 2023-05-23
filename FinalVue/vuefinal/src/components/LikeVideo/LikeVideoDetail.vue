<template>
  <div class="text-content">
    <router-link :to="{ name: 'detail' }">
      <img :src="`${video.thumbnails}`" /><br />
    </router-link>
    {{ video.title }}<br />
    {{ video.channelName }}<br />
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
    };
  },
  created() {
    http
      .get(`/video/detail/${this.info.youtubeId}`)
      .then((res) => (this.video = res.data));
  },
};
</script>

<style scoped>
.text-content {
  text-align: center;
}
</style>
