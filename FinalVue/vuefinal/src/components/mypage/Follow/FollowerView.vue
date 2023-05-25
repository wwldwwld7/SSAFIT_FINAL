<template>
  <div>
    <!-- Follower -->
    <ul>
      <div
        v-for="(info, index) in followedList"
        :key="index"
        style="height: 43; width: 300"
      >
        <follower-view-result :info="info"></follower-view-result>
      </div>
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

<style scoped></style>
