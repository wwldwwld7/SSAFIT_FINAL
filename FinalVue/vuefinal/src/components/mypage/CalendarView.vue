<!-- 식단관리 -->
<template>
  <div>
    식단관리
    <detail-calender></detail-calender>
  </div>
</template>

<script>
import DetailCalender from "./Calendar/DetailCalender.vue";

export default {
  name: "CalendarView",
  components: { DetailCalender },
};
</script>

<style></style>
