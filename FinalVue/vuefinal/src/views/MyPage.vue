<!-- 마이 페이지 화면 -->
<template>
  <div>
    <h2>마이페이지</h2>
    <div>
      <router-link :to="{ name: 'calender-view' }">식단관리</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyPage",
};
</script>

<style></style>
