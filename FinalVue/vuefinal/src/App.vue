<template>
  <div id="app">
    <header-nav></header-nav>
    <div class="view">
      <router-view />
    </div>
    <footer id="footer">
      <div class="company-details">
        <div class="row">
          <div id="col1">
            <v-icon>mdi-map-marker</v-icon>

            <span>
              대전광역시 유성구 동서대로
              <br />98-39
            </span>
          </div>

          <div id="col2">
            <v-icon>mdi-phone</v-icon>

            <span> Telephone: +82-042-820-7385 </span>
          </div>

          <div id="col3">
            <v-icon>mdi-email-outline</v-icon>
            <span>wwldwwld7@naver.com</span><br />
            <span>acd4548@naver.com</span>
          </div>
        </div>
      </div>

      <!-- Copyright Section -->
      <div class="copyright">
        <p>Copyright © SAMSUNG All Rights Reserved</p>

        <ul class="contact">
          <li>
            <a href="#" class="fa fa-twitter"> </a>
          </li>

          <li>
            <a href="#" class="fa fa-facebook"> </a>
          </li>

          <li>
            <a href="#" class="fa fa-pinterest-p"> </a>
          </li>
        </ul>
      </div>
    </footer>
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";

export default {
  components: {
    HeaderNav,
  },
};
</script>

<style scoped>
.company-details {
  overflow: hidden;
  padding: 3em 0em;
  background: #e3f0f7;
  width: 100%;
  /* display: flex; */
  /* justify-content: space-around; */
  /* align-content: center; */
  /* text-align: center; */
  margin-top: 5em;
  color: rgb(42, 42, 133);
}
.row {
  width: 100%;
  text-align: center;
  display: flex;
  justify-content: space-around;
}
#footer #col1,
#footer #col2,
#footer #col3 {
  float: left;
  width: 320px;
  /* padding: 0px 40px 0px 40px; */
}

#footer #icon {
  display: block;
  margin-bottom: 1em;
  font-size: 3em;
}
.copyright {
  overflow: hidden;
  padding: 3em 0em;
  border-top: 20px solid rgba(255, 255, 255, 0.08);
  text-align: center;
  background: rgb(42, 42, 133);
}
.copyright p {
  letter-spacing: 1px;
  font-size: 0.9em;
  color: rgba(255, 255, 255, 0.6);
}
.copyright a {
  text-decoration: none;
  color: rgba(255, 255, 255, 0.8);
}
.view {
  height: 900px;
}
</style>
