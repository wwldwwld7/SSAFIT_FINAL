<template>
  <div>
    <ul>
      <li v-for="(comment, index) in comments" :key="index">
        여기
        {{ comment.content }}
        아냐?
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "DetailVideoCommentList",
  props: {
    comments: Array,
  },
  data() {
    return {
      comment: {},
    };
  },
};
</script>

<style></style>
