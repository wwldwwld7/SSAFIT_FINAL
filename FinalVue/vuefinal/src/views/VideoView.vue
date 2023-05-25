<template>
  <div>
    <div>
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

<style></style>
