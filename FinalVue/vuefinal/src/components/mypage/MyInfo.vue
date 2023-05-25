<template>
  <div class="container">
    <table>
      <tr>
        <td class="item">이름</td>
        <td>{{ loginUser.name }}</td>
      </tr>
      <tr>
        <td class="item">아이디</td>
        <td>{{ loginUser.userId }}</td>
      </tr>
      <tr>
        <td class="item">닉네임</td>
        <td>{{ loginUser.nickName }}</td>
      </tr>
      <tr>
        <td class="item">상태 메시지</td>
        <td>{{ loginUser.stateMsg }}</td>
      </tr>
    </table>
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
.container {
  margin-top: 50px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  border-radius: 8px;
  box-shadow: 0 0 20px gainsboro;
  padding: 60px 80px;
  width: 600px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

th,
td {
  padding: 20px;
  border-bottom: 1px solid #e0e0e0;
  white-space: nowrap;
}

th {
  background-color: #f5f5f5;
}

button {
  padding: 16px 50px;
  background-color: rgb(42, 42, 133);
  border-radius: 10px;
  color: white;
}

button:hover {
  box-shadow: 0 5px 30px rgb(185, 185, 250);
}

td:nth-child(2) {
  font-weight: bold;
}
.item {
  background: #f6f7fa;
  width: 120px;
}
</style>
