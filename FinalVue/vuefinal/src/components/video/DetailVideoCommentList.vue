<template>
  <div class="text-content3">
    <ul class="line" style="list-style-type: none">
      <li v-for="(comment, index) in comments" :key="index">
        <div class="row" v-if="loginedUser == comment.nickName">
          <div class="nickName">
            <router-link
              style="color: rgb(42, 42, 133)"
              :to="{
                name: 'mypagemain',
                params: { nickName: comment.nickName },
              }"
              >{{ comment.nickName }}</router-link
            >
            <div class="registDate">
              {{ comment.registDate }}
            </div>
          </div>
          <div class="content">
            <div class="c-content">{{ comment.content }}<br /></div>
          </div>
          <div class="btn">
            <button
              class="modi"
              v-if="loginedUser === comment.nickName"
              @click="modify(comment)"
            >
              수정
            </button>
            <button
              class="remove"
              style="color: red; margin-left: 5px"
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
              style="color: rgb(42, 42, 133)"
              :to="{
                name: 'guest',
                params: { nickName: comment.nickName },
              }"
              >{{ comment.nickName }}</router-link
            >
            <div class="registDate">
              {{ comment.registDate }}
            </div>
          </div>
          <div class="content">
            <div class="c-content">{{ comment.content }}<br /></div>
          </div>
          <div class="btn"></div>
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
    console.log(this.comments);
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
  margin-bottom: 50px;
  width: 500px;
}
.row {
  margin: 10px 0px;
  padding: 1px 0px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-direction: column;
  border-style: dashed;
  border-width: 1px 0px;
  border-color: gray;
}
.line > li {
  height: 90px;
}

.nickName {
  width: 100%;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: flex-start;
}
.nickName > a {
  color: black;
  text-decoration: none;
  font-weight: bolder;
}
.content {
  height: 30px;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.btn {
  height: 30px;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  color: gray;
}

.c-content {
  height: 30px;
  line-height: 30px;
  font-weight: bolder;
}

.registDate {
  font-size: smaller;
  height: 30px;
  color: gray;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 100;
}
</style>
