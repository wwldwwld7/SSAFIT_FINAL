<template>
  <div>
    <div class="title">
      <h2>마이페이지</h2>
    </div>
    <div class="container">
      <div>
        <router-link class="link" :to="{ name: 'calendar-view' }"
          ><img
            style="width: 200px; height: 200px"
            src="https://cdn.icon-icons.com/icons2/620/PNG/512/calendar-weekly_icon-icons.com_56832.png"
            alt="calendar"
          />식단관리</router-link
        >
      </div>
      <div style="width: 200px; height: 200px">
        <router-link class="link" :to="{ name: 'comment-list' }"
          ><img
            style="width: 200px; height: 200px"
            src="https://cdn.icon-icons.com/icons2/602/PNG/512/Comments_icon-icons.com_55940.png"
            alt="comment"
          />작성한 댓글</router-link
        >
      </div>
      <div style="width: 200px; height: 200px">
        <router-link
          class="link"
          :to="{ name: 'like-videos', params: { type: 'user' } }"
        >
          <img
            style="width: 200px; height: 200px"
            src="https://cdn.icon-icons.com/icons2/2090/PNG/512/video_icon_128429.png"
            alt="video"
          />찜한 영상</router-link
        >
      </div>
      <div style="width: 200px; height: 200px">
        <router-link
          class="link"
          :to="{ name: 'follow-view', params: { type: 'user' } }"
        >
          <img
            style="width: 200px; height: 200px"
            src="https://cdn-icons-png.flaticon.com/512/2583/2583035.png"
            alt="follow"
          />팔로잉/팔로워</router-link
        >
      </div>
      <div style="width: 200px; height: 200px">
        <router-link class="link" :to="{ name: 'my-info' }">
          <img
            style="width: 200px; height: 200px"
            src="https://cdn-icons-png.flaticon.com/512/3076/3076343.png"
            alt="myinfo"
          />회원정보</router-link
        >
      </div>
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
  created() {
    this.$store.dispatch("makeUserType", "user");
  },
};
</script>

<style scoped>
.title {
  margin-top: 50px;
  margin-bottom: 50px;
  padding-bottom: 50px;
  text-align: center;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  box-shadow: 0px 4px 4px -4px;
}
.container {
  text-align: center;
}
.container div {
  display: inline-block;
  align-content: space-between;
  margin-right: 50px;
  margin-left: 50px;
}
div img {
  display: flex;
  margin-bottom: 50px;
}
.link {
  text-decoration: none;
  color: rgb(42, 42, 133);
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
</style>
