<!-- 마이 페이지 화면 -->
<template>
  <div>
    <h2>마이페이지</h2>
    <div>
      <v-icon style="color: black" large>mdi-calendar-month</v-icon>
      <router-link :to="{ name: 'calendar-view' }">식단관리</router-link>
      <router-link :to="{ name: 'comment-list' }">작성한 댓글</router-link>
      <router-link :to="{ name: 'like-videos', params: { type: 'user' } }"
        >찜한 영상</router-link
      >
      <router-link :to="{ name: 'follow-view', params: { type: 'user' } }"
        >팔로잉/팔로워</router-link
      >
      <router-link :to="{ name: 'my-info' }">회원정보</router-link>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "MyPageMain",
  computed: {
    ...mapGetters(["loginUser"]),
  },
};
</script>

<style></style>
