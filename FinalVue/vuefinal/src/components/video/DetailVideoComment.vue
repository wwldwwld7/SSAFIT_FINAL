<!-- 댓글창 화면 -->
<template>
  <div class="text-content2">
    <div style="margin-top: 5px" class="search">
      <input
        placeholder="댓글"
        class="inputbox"
        type="text"
        v-model="content"
      />
      <button class="btn" @click="regist(content)">등록</button>
    </div>
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

<style scoped>
.text-content2 {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.search {
  width: 500px;
  height: 35px;
  background-color: #e5e9f5;
  font-style: sans-serif;
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.inputbox {
  text-indent: 2%;
  width: 452px;
  height: 35px;
}
.inputbox:focus {
  outline: none;
}
input {
  outline: 5px;
}
.btn {
  float: right;
  width: 48px;
  height: 30px;
  background-color: #e5e9f5;
  color: black;
  border-radius: 5px;
  font-weight: bolder;
}
</style>
