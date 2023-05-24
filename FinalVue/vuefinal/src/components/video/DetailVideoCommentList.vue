<template>
  <div class="text-content3">
    <ul class="line" style="list-style-type: none">
      <li v-for="(comment, index) in comments" :key="index">
        <div>
          <div class="row" v-if="loginedUser == comment.nickName">
            <div class="nickName">
              <router-link
                :to="{
                  name: 'mypagemain',
                  params: { nickName: comment.nickName },
                }"
                >{{ comment.nickName }}</router-link
              >
            </div>
            <div class="content">
              {{ comment.content }}
            </div>
            <div class="btn">
              <button
                v-if="loginedUser === comment.nickName"
                @click="modify(comment)"
              >
                수정
              </button>
              <button
                style="margin-left: 5px"
                v-if="loginedUser === comment.nickName"
                @click="remove(comment)"
              >
                삭제
              </button>
            </div>
          </div>
          <div class="row" v-if="loginedUser != comment.nickName">
            <div class="nickName">
              <router-link
                :to="{ name: 'guest', params: { nickName: comment.nickName } }"
                >{{ comment.nickName }}</router-link
              >
            </div>
            <div class="content">
              {{ comment.content }}
            </div>
            <div class="btn">
              <button
                v-if="loginedUser === comment.nickName"
                @click="modify(comment)"
              >
                수정
              </button>
              <button
                v-if="loginedUser === comment.nickName"
                @click="remove(comment)"
              >
                삭제
              </button>
            </div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";

export default {
  name: "DetailVideoCommentList",
  props: {
    comments: Array,
  },
  data() {
    return {
      comment: {},
      loginedUser: "",
    };
  },
  created() {
    this.loginedUser = this.loginUser.nickName;
  },
  computed: {
    ...mapGetters(["loginUser"]),
  },
  methods: {
    modify(value) {
      this.$router.push({
        name: "modify-comment",
        params: { comment: value, type: "video" },
      });
    },
    remove(value) {
      var delConfirm = confirm("댓글을 삭제하시겠습니까?");
      if (delConfirm) {
        http.delete(`/comment/${value.commentId}`).then(this.$router.go(0));
      } else {
        alert("삭제가 취소되었습니다.");
      }
    },
    mypage() {},
    guestpage() {},
  },
};
</script>

<style scoped>
.text-content3 {
  margin-top: 10px;
}
.row {
  display: flex;
  align-items: center;
  justify-content: center;
}
.line > li {
  height: 35px;
}
.line * {
  margin-top: 1px;
}
.nickName {
  width: 50px;
}
.nickName * {
  color: black;
  text-decoration: none;
  font-weight: bolder;
}
.content {
  width: 370px;
  font-weight: bolder;
}
.btn {
  width: 80px;
  color: gray;
}
.btn * {
  padding: auto;
}
</style>
