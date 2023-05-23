<!-- 완전 초기화면 -->

<template>
  <v-carousel>
    <v-carousel-item
      v-for="(item, index) in items"
      :key="index"
      :src="item.src"
      reverse-transition="fade-transition"
      transition="fade-transition"
    ></v-carousel-item>
  </v-carousel>
</template>

<script>
export default {
  name: "HomeView",
  components: {},
  data() {
    return {
      items: [
        {
          src: "https://mblogthumb-phinf.pstatic.net/20160723_80/rimiy_1469204734914Vwi69_JPEG/1.jpeg?type=w2",
        },
        {
          src: "https://images.pexels.com/photos/1472887/pexels-photo-1472887.jpeg?auto=compress&cs=tinysrgb&w=1600",
        },
        {
          src: "https://images.pexels.com/photos/1552249/pexels-photo-1552249.jpeg?auto=compress&cs=tinysrgb&w=1600",
        },
        {
          src: "https://images.pexels.com/photos/2294361/pexels-photo-2294361.jpeg?auto=compress&cs=tinysrgb&w=1600",
        },
        {
          src: "https://images.pexels.com/photos/2597884/pexels-photo-2597884.jpeg?auto=compress&cs=tinysrgb&w=1600",
        },
      ],
    };
  },
};
</script>
:touch={ left: () => activeSlide--, right: () => activeSlide++ }

<style scoped>
.v-window__next {
  background: rgba(0, 0, 0, 0.15);
  height: 68px;
  width: 68px;
  top: calc(50% - 33px);
  margin-right: 13%;
}
.v-window__prev {
  background: rgba(0, 0, 0, 0.15);
  height: 68px;
  width: 68px;
  top: calc(50% - 33px);
  margin-left: 13%;
}
</style>
