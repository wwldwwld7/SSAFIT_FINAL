<template>
  <div>
    FollowerView 입니당
    <ul>
      <li v-for="(info, index) in followedList" :key="index">
        <follower-view-result :info="info"></follower-view-result>
      </li>
    </ul>
  </div>
</template>

<script>
import FollowerViewResult from "@/components/mypage/Follow/FollowerViewResult.vue";

export default {
  name: "FollowerView",
  props: {
    followedList: Array,
  },
  components: {
    FollowerViewResult,
  },
};
</script>

<style></style>
