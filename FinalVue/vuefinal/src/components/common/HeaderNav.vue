<template>
  <header>
    <div class="container">
      <div class="center">
        <h1>
          <a v-if="!loginUser" href="http://localhost:8080/"
            ><v-icon large style="color: #ffd400">mdi-arm-flex</v-icon
            >SSAFIT<v-icon class="re" large style="color: #ffd400"
              >mdi-arm-flex</v-icon
            ></a
          >
        </h1>
        <h1>
          <a v-if="loginUser" href="http://localhost:8080/video"
            ><v-icon large style="color: #ffd400">mdi-arm-flex</v-icon
            >SSAFIT<v-icon class="re" large style="color: #ffd400"
              >mdi-arm-flex</v-icon
            ></a
          >
        </h1>
      </div>
      <div class="right">
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
              <button
                v-if="loginUser"
                @click="doLogOut"
                class="hover-link"
                id="logout"
              >
                로그아웃
              </button>
            </li>
          </ul>
        </nav>
      </div>
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
  color: white;
  text-decoration: none;
}

header {
  display: flex;
  justify-content: center;
  background: rgb(42, 42, 133);
}

.container {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  width: 1270px;
  margin-top: 80px;
}

.center {
  text-align: center;
}

nav {
  float: right;
}

ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

li {
  display: inline-block;
  margin-left: 10px;
}

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
#logout {
  font-size: 15px;
  color: gray;
}
#logout:hover {
  color: #22aee5;
}
.re {
  -webkit-transform: rotateY(180deg);
}
</style>
