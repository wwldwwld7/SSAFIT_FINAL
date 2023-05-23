<template>
  <div class="text-content">
    <img :src="`${thumbnails}`" /><br />
    {{ title }}<br />
    {{ comment.content }}<br />
    <button @click="modify(comment)">수정</button>
    <button @click="remove(comment)">삭제</button>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "CommentDetail",
  props: {
    comment: Object,
  },
  data() {
    return {
      video: {},
      thumbnails: "",
      title: "",
    };
  },
  methods: {
    modify(value) {
      value;
    },
    remove(value) {
      console.log(value);
      http.delete(`/comment/${value.commentId}`).then(this.$router.go(0));
    },
  },
  created() {
    http
      .get(`/video/detail/${this.comment.youtubeId}`)
      .then((res) => (this.video = res.data))
      .then(() => {
        this.thumbnails = this.video.thumbnails;
        this.title = this.video.title;
      });
  },
};
</script>

<style>
.text-content {
  text-align: center;
}
</style>
