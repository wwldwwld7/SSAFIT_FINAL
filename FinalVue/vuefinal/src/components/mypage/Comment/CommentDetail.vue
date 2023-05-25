<template>
  <div class="text-content">
    <div class="center">
      <div class="thumbnails">
        <img :src="`${thumbnails}`" />
      </div>
      <div class="title">
        {{ title }}
      </div>
      <div class="comment">
        <div class="context">
          <div class="content">
            {{ comment.content }}
          </div>
          <div>
            <div class="btn">
              <button class="modi" @click="modify(comment)">수정</button>
              <button class="remo" @click="remove(comment)">삭제</button>
            </div>
            <div class="date">
              {{ comment.registDate }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "CommentDetail",
  props: {
    comment: Object,
  },
  data() {
    return {
      video: {},
      thumbnails: "",
      title: "",
    };
  },
  methods: {
    modify(value) {
      this.$router.push({
        name: "modify-comment",
        params: { comment: value, type: "comment" },
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
  },
  created() {
    http
      .get(`/video/detail/${this.comment.youtubeId}`)
      .then((res) => (this.video = res.data))
      .then(() => {
        this.thumbnails = this.video.thumbnails;
        this.title = this.video.title;
      });
  },
};
</script>

<style scoped>
.text-content {
  margin-top: 10px;
  margin-bottom: 50px;
  text-align: center;
}
.text-content * {
  margin-bottom: 4px;
}
.comment {
  width: 550px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  border-style: dashed;
  border-width: 1px 0px;
  border-color: gray;
  margin: 0 auto;
  margin-top: 10px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.center {
}

img {
  height: 170px;
}
.context {
  display: flex;
  align-items: center;
  justify-content: center;
}

.title {
}

.content {
  width: 400px;
  font-weight: bolder;
}
.btn {
  margin-top: 10px;
  width: 80px;
  color: gray;
}
.remo {
  margin-left: 6px;
  color: red;
}
.date {
  color: gray;
  font-size: 12px;
  font-weight: 1px;
}
</style>
