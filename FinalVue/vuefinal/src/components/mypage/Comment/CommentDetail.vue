<template>
  <div class="text-content">
    <div>
      <div class="thumbnails">
        <img :src="`${thumbnails}`" />
      </div>
      <div class="title">
        {{ title }}
      </div>
      <div class="context">
        <div class="content">
          {{ comment.content }}
        </div>
        <div class="btn">
          <button @click="modify(comment)">수정</button>
          <button @click="remove(comment)">삭제</button>
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
      http.delete(`/comment/${value.commentId}`).then(this.$router.go(0));
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
  text-align: center;
}
.text-content * {
  margin-bottom: 4px;
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
  font-weight: bolder;
}

.content {
  width: 400px;
  font-weight: bolder;
}
.btn {
  width: 80px;
  color: gray;
}
</style>
