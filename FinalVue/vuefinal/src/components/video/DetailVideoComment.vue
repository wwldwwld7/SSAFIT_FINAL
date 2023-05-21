<!-- 댓글창 화면 -->
<template>
  <div>
    <input type="text" v-model="content" />
    <button @click="regist(content)">등록</button>
    <hr />
    <detail-video-comment-list></detail-video-comment-list>
  </div>
</template>

<script>
import DetailVideoCommentList from "./DetailVideoCommentList.vue";
// import http from "@/util/http-common";
export default {
  components: { DetailVideoCommentList },
  name: "DetailVideoComment",
  data() {
    return {
      content: "",
    };
  },
  props: {
    youtubeId: String,
  },
  methods: {
    regist(value) {
      console.log(this.youtubeId);
      console.log(value);
      // http.post("/")
    },
  },
};
</script>

<style></style>
