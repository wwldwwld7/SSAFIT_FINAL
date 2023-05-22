<template>
  <header>
    <div class="container">
      <div class="left">
        <h1><a v-if="!loginUser" href="http://localhost:8080/">SSAFIT</a></h1>
        <h1>
          <a v-if="loginUser" href="http://localhost:8080/video">SSAFIT</a>
        </h1>
      </div>
      <nav>
        <ul>
          <li>
            <router-link v-if="!loginUser" to="/user" class="hover-link">
              로그인
            </router-link>
          </li>
          <li>
            <router-link v-if="loginUser" to="/mypage" class="hover-link">
              {{ loginUser.nickName
              }}<span style="color: black, font-weight: normal;"
                >님 환영합니다.</span
              >
            </router-link>
          </li>
          <li>
            <button v-if="loginUser" @click="doLogOut" class="hover-link">
              로그아웃
            </button>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "HeaderNav",
  computed: {
    ...mapGetters(["loginUser"]),
  },
  methods: {
    doLogOut() {
      this.$store.dispatch("doLogOut").then(() => {
        this.$router.push("/");
      });
    },
  },
};
</script>

<style scoped>
a:link,
a:visited,
a:hover,
a:active {
  color: navy;
  text-decoration: none;
}
header {
  display: flex;
  justify-content: space-between;
}

.container {
  width: 1270px;
  /* margin: 0 auto; */
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.left {
  flex-grow: 1;
  text-align: center;
}

nav ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

nav ul li {
  display: inline-block;
  margin-left: 10px;
}
header nav ul {
  display: flex;
  text-align: center;
}
/* .hover-link.active {
  color: #22aee5;
} */

/* .hover-link {
  color: var(--blueColor);
} */

.hover-link:hover {
  color: #22aee5;
}
.hover-link:after {
  opacity: 0;
  content: "";
  position: absolute;
  width: 100%;
  height: 2px;
  background-color: #22aee5;
  left: 0;
  bottom: 0;
  transition: all 0.3s ease-in-out;
}
.hover-link {
  position: relative;
  display: inline-block;
  line-height: 5rem;
  font-weight: bold;
  font-size: 1.0625rem;
}
</style>
