<template>
  <div>
    <ul>
      <li v-for="(video, index) in videos" :key="index">
        <search-video-result-list :video="video"></search-video-result-list>
      </li>
    </ul>
  </div>
</template>

<script>
import SearchVideoResultList from "./SearchVideoResultList.vue";

export default {
  name: "SearchVideoResult",
  props: {
    videos: Array,
  },
  components: { SearchVideoResultList },
  data() {
    return {};
  },
  methods: {
    storeVideo(value) {
      this.$store.dispatch("storeVideo", value);
    },
  },
};
</script>

<style></style>
