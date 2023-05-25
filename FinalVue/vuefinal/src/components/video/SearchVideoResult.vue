<template>
  <div class="search-video-result">
    <ul class="video-list">
      <li v-for="(video, index) in videos" :key="index" class="video-item">
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
};
</script>

<style>
.search-video-result {
  margin-top: 20px;
}

.video-list {
  list-style-type: none;
  padding: 0;
}

.video-item {
  margin-bottom: 10px;
}
</style>
