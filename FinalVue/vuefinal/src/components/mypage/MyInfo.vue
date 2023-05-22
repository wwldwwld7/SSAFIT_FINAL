<!-- 회원정보 -->
<template>
  <div>
    <div>
      <span>이름</span><span class="info">{{ loginUser.name }}</span>
    </div>
    <div>
      <span>아이디</span><span class="info">{{ loginUser.userId }}</span>
    </div>
    <div>
      <span>닉네임</span><span class="info">{{ loginUser.nickName }}</span>
    </div>
    <div>
      <span>상태 메세지</span><span class="info">{{ loginUser.stateMsg }}</span>
    </div>
    <button @click="modify">회원정보 수정</button>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "MyInfo",
  computed: {
    ...mapGetters(["loginUser"]),
  },
  methods: {
    modify() {
      this.$router.push({ name: "modify-form" });
    },
  },
};
</script>

<style scoped>
div > div {
  width: 300px;
  margin-bottom: 10px;
}

.info {
  border: none;
  padding: 5px;
  background-color: #e0e0e0;
  border-radius: 8px;
  font-weight: bold;
}
</style>
