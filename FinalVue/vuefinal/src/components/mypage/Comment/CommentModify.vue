<template>
  <div class="main">
    <div class="text-content">
      <div>
        <h4>댓글 내용</h4>
      </div>
      <div class="input">
        <input
          type="content"
          id="content"
          name="content"
          v-model="content"
          ref="content"
        />
      </div>
      <div class="btn">
        <button @click="modify">수정</button>
      </div>
    </div>
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

<style scoped>
.text-content {
  margin-top: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.text-content * {
  margin-bottom: 10px;
}
.main {
  height: 50px;
}

input {
  width: 300px;
  height: 100px;
  outline: auto;
  text-indent: 5%;
}
.btn {
  display: flex;
  float: right;
}
</style>
