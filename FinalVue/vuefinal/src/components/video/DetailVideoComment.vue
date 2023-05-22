<!-- 댓글창 화면 -->
<template>
  <div>
    <input type="text" v-model="content" />
    <button @click="regist(content)">등록</button>
    <hr />
    <detail-video-comment-list :comments="comments"></detail-video-comment-list>
  </div>
</template>

<script>
import DetailVideoCommentList from "./DetailVideoCommentList.vue";
import { mapState } from "vuex";
import http from "@/util/http-common";

export default {
  components: { DetailVideoCommentList },
  name: "DetailVideoComment",
  data() {
    return {
      content: "",
      comments: [],
    };
  },
  props: {
    youtubeId: String,
  },
  methods: {
    regist(value) {
      const comment = {
        youtubeId: this.youtubeId,
        content: value,
        nickName: this.loginUser.nickName,
      };
      http.post("/comment", comment).then(this.$router.go(0));
    },
  },
  computed: {
    ...mapState(["loginUser"]),
  },
  async created() {
    await http
      .get(`/comment/video/${this.youtubeId}`)
      .then((res) => {
        return res.data;
      })
      .then((res) => {
        this.comments = res;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style></style>
