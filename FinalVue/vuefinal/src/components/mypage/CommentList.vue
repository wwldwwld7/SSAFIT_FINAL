<template>
  <div class="container">
    <div class="title">
      <h3>{{ this.nickName }}</h3>
      님의 댓글
    </div>
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
.container {
  text-align: center;
  width: 1000px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
h1 {
  text-align: center;
}
.title {
  margin-top: 50px;
  margin-bottom: 50px;
  display: inline-flex;
}
</style>
