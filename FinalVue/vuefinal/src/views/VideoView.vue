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
  components: {},
  data() {
    return {
      //created든 수동적으로 넣든 json으로 기본 영상정보 넣어주기.
      videos: [],
      video: {},
    };
  },
  methods: {},
};
</script>

<style></style>
