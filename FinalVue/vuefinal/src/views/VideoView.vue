<template>
  <div class="container">
    <div class="con2">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "VideoView",
  data() {
    return {
      videos: [],
      video: {},
    };
  },
};
</script>

<style scoped>
.container {
  /* max-height: 1000px; */
  height: auto;
}
.con2 {
  /* height: 200px; */
}
</style>
