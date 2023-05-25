<template>
  <div>
    <div class="title">
      <h3>
        {{ guestUser
        }}<span style="font-size: 17px; color: gray">님의 페이지</span>
      </h3>
      <div v-if="followflag">
        <button class="follow-btn-following" @click="unfollow">
          Following
        </button>
      </div>
      <div v-if="!followflag">
        <button class="follow-btn-follow" @click="follow">Follow</button>
      </div>
    </div>
    <div class="container">
      <div>
        <router-link class="link" :to="{ name: 'calendar-view' }">
          <img
            style="width: 200px; height: 200px"
            src="https://cdn.icon-icons.com/icons2/620/PNG/512/calendar-weekly_icon-icons.com_56832.png"
            alt="calendar"
          />캘린더</router-link
        >
      </div>
      <div>
        <router-link
          class="link"
          :to="{ name: 'like-videos', params: { type: 'guest' } }"
        >
          <img
            style="width: 200px; height: 200px"
            src="https://cdn.icon-icons.com/icons2/2090/PNG/512/video_icon_128429.png"
            alt="video"
          />찜 목록</router-link
        >
      </div>
      <div>
        <router-link
          class="link"
          :to="{ name: 'follow-view', params: { type: 'guest' } }"
        >
          <img
            style="width: 200px; height: 200px"
            src="https://cdn-icons-png.flaticon.com/512/2583/2583035.png"
            alt="follow"
          />팔로워/팔로잉</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import http from "@/util/http-common";

export default {
  name: "GuestPage",
  data() {
    return {
      nickName: "",
      followflag: "",
    };
  },
  methods: {
    unfollow() {
      http
        .delete(`/follow/${this.loginUser.nickName}/${this.nickName}`)
        .then(() => {
          this.followflag = !this.followflag;
        });
    },
    follow() {
      const follow = {
        follower: this.loginUser.nickName,
        following: this.nickName,
      };
      http
        .post("/follow", follow)
        .then(() => (this.followflag = !this.followflag));
    },
  },
  computed: {
    ...mapGetters(["loginUser", "guestUser"]),
  },
  created() {
    //게스트의 마이페이지로 들어오면 state의 userType을 "guest"로 바꿔준다.
    this.$store.dispatch("makeUserType", "guest");

    if (this.$route.params.nickName != null) {
      this.$store.dispatch("guest", this.$route.params.nickName);
    }
    this.nickName = this.guestUser;
    console.log(this.nickName);
    http
      .get(`/follow/${this.loginUser.nickName}/${this.nickName}`)
      .then((res) => {
        if (res.status == 204) {
          this.followflag = false;
        } else {
          this.followflag = true;
        }
      });
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
.follow-btn-follow {
  padding: 3px 3px;
  background: blue;
  border-radius: 20px;
  color: white;
  font-weight: bold;
  font-size: 14px;
}
.follow-btn-following {
  padding: 3px 3px;
  background: red;
  border-radius: 20px;
  color: white;
  font-weight: bold;
  font-size: 14px;
}
</style>
