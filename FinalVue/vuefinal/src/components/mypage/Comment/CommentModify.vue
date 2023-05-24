<template>
  <div>
    <h4>수정</h4>
    <label for="content">내용</label>
    <input
      type="content"
      id="content"
      name="content"
      v-model="content"
      ref="content"
    />
    <button @click="modify">수정</button>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "CommentModify",
  data() {
    return {
      content: "",
      comment: {},
      type: "",
    };
  },
  methods: {
    modify() {
      const comment = {
        commentId: this.comment.commentId,
        content: this.content,
        likeCnt: this.comment.likeCnt,
        nickName: this.comment.nickName,
        registDate: this.comment.registDate,
        youtubeId: this.comment.youtubeId,
      };
      if (this.type === "comment") {
        http
          .put("/comment", comment)
          .then((res) => console.log(res))
          .then(this.$router.push({ name: "comment-list" }))
          .then(this.$router.go(0));
      } else {
        http
          .put("/comment", comment)
          .then((res) => console.log(res))
          .then(this.$router.push({ name: "detail" }))
          .then(this.$router.go(0));
      }
    },
  },
  created() {
    this.type = this.$route.params.type;
    this.comment = this.$route.params.comment;
    this.content = this.comment.content;
    console.log(this.comment);
  },
};
</script>

<style></style>
