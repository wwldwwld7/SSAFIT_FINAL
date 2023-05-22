<template>
  <div>
    <ul>
      <li v-for="(comment, index) in comments" :key="index">
        <router-link
          :to="{ name: 'follow-view', params: { nickName: comment.nickName } }"
          >{{ comment.nickName }}</router-link
        >
        {{ comment.content }}
        <button v-if="loginedUser === loginUser" @click="modify(comment)">
          수정
        </button>
        <button v-if="loginedUser === loginUser" @click="remove(comment)">
          삭제
        </button>
      </li>
    </ul>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

export default {
  name: "CommentListResult",
  props: {
    nickName: String,
  },
  data() {
    return {
      comments: [],
      loginedUser: "",
    };
  },
  async created() {
    this.loginedUser = this.loginUser;
    console.log(this.nickName);
    await http.get(`/comment/user/${this.nickName}`).then((res) => {
      console.log(res);
      this.comments = res.data;
    });
  },
  computed: {
    ...mapState(["loginUser"]),
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
