<template>
  <div class="container">
    <!-- Follower -->
    <ul>
      <div v-for="(info, index) in followedList" :key="index">
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

<stylescoped>

</style>
