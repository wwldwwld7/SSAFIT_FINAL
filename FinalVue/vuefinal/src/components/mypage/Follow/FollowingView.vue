<template>
  <div>
    <!-- Following -->
    <ul>
      <div v-for="(info, index) in followList" :key="index">
        <following-view-result :info="info"></following-view-result>
      </div>
    </ul>
  </div>
</template>

<script>
import FollowingViewResult from "@/components/mypage/Follow/FollowingViewResult.vue";

export default {
  name: "FollowingView",
  props: {
    followList: Array,
  },
  components: {
    FollowingViewResult,
  },
};
</script>

<style></style>
