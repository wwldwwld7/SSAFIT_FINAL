<template>
  <div>
    <router-link
      :to="{ name: 'follow-view', params: { nickName: comment.nickName } }"
      >{{ comment.nickName }}</router-link
    >
    {{ comment.content }}
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
  methods: {
    modify(value) {
      value;
    },
    remove(value) {
      console.log(value);
      http.delete(`/comment/${value.commentId}`).then(this.$router.go(0));
    },
  },
};
</script>

<style></style>
