<template>
  <div>{{ nickName }}</div>
</template>

<script>
export default {
  name: "FollowingViewResult",
  props: {
    info: Object,
  },
  data() {
    return {
      nickName: "",
      stateMsg: "",
    };
  },
  created() {
    this.nickName = this.info.nickName;
    this.stateMsg = this.info.stateMsg;
  },
};
</script>

<style></style>
