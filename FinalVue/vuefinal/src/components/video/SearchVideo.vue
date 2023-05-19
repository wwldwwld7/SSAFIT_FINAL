<!-- 영상 메인화면 ( 검색창 + 검색 결과에 따른 영상 리스트) -->
<template>
  <div>
    <input type="text" v-model="keyword" />
    <button @click="search">검색</button>
  </div>
</template>

<script>
export default {
  name: "SearchVideo",
  data() {
    return {
      keyword: "",
    };
  },
  methods: {
    search() {
      this.$emit("search-input", this.keyword);
    },
  },
};
</script>

<style></style>
