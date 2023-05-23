<template>
  <div>
    <ul>
      <li v-for="(comment, index) in comments" :key="index">
        <comment-detail :comment="comment"></comment-detail>
      </li>
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

<style></style>
