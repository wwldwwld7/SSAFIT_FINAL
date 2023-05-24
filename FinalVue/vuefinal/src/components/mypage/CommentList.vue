<!-- 작성한 댓글 화면 -->
<template>
  <div>
    <h1>{{ temp }}</h1>
    <comment-list-result :nickName="nickName"></comment-list-result>
  </div>
</template>

<script>
import CommentListResult from "@/components/mypage/Comment/CommentListResult.vue";
import { mapGetters } from "vuex";
import http from "@/util/http-common";

export default {
  name: "CommentList",
  components: {
    CommentListResult,
  },
  computed: {
    ...mapGetters(["loginUser"]),
  },
  data() {
    return {
      temp: "< 내가 남긴 댓글 ~ >",
      nickName: "",
      comments: [],
    };
  },
  created() {
    this.nickName = this.loginUser.nickName;
    http
      .get(`/comment/user/${this.nickName}`)
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

<style scoped>
h1 {
  text-align: center;
}
</style>
