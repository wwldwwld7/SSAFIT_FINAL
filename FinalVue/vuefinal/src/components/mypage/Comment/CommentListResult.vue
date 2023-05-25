<template>
  <div class="container">
    <ul>
      <div class="comment" v-for="(comment, index) in comments" :key="index">
        <comment-detail :comment="comment"></comment-detail>
      </div>
    </ul>
  </div>
</template>

<script>
import http from "@/util/http-common";
import CommentDetail from "./CommentDetail.vue";

export default {
  components: { CommentDetail },
  name: "CommentListResult",
  props: {
    nickName: String,
  },
  data() {
    return {
      comments: [],
    };
  },
  async created() {
    await http.get(`/comment/user/${this.nickName}`).then((res) => {
      this.comments = res.data;
    });
  },
};
</script>

<style scoped>
.container {
  margin-top: 10px;
  margin-bottom: 50px;
  width: 500px;
}
.comment {
  /* display: flex;
  align-items: center;
  justify-content: center; */
}
</style>
