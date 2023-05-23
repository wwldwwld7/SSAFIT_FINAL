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
          src: "https://mblogthumb-phinf.pstatic.net/20160723_87/rimiy_1469204735995kCsvw_JPEG/5.jpg?type=w2",
        },
        {
          src: "https://mblogthumb-phinf.pstatic.net/20160723_80/rimiy_1469204734914Vwi69_JPEG/1.jpeg?type=w2",
        },
        {
          src: "https://mblogthumb-phinf.pstatic.net/20160723_80/rimiy_1469204734914Vwi69_JPEG/1.jpeg?type=w2",
        },
        {
          src: "https://mblogthumb-phinf.pstatic.net/20160723_80/rimiy_1469204734914Vwi69_JPEG/1.jpeg?type=w2",
        },
      ],
    };
  },
};
</script>
:touch={ left: () => activeSlide--, right: () => activeSlide++ }

<style scoped></style>
