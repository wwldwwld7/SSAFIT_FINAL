<template>
  <div class="container">
    <div class="title">
      <h3>{{ this.nickName }}</h3>
      님의 calendar
    </div>
    <div class="calendar">
      <FullCalendar :options="calendarOptions" />
    </div>
    <v-app v-model="isShow" v-if="isShow" max-width="500">
      <v-dialog v-model="isShow" v-if="isShow" max-width="500">
        <v-card>
          <v-card-title>
            <h3 class="text-h5">운동 등록</h3>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6" md="4">
                  <v-text-field
                    v-model="w_name"
                    label="운동 종류"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="4">
                  <v-text-field v-model="w_cnt" label="횟수(분)"></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="4">
                  <v-text-field
                    v-model="set_cnt"
                    label="세트 수"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue-darken-1" variant="text" @click="save">
              등록
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-app>
  </div>
</template>

<script>
import http from "@/util/http-common";
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";
import { mapGetters } from "vuex";

export default {
  name: "CalendarView",
  mounted() {
    http.get(`/workout/my/${this.nickName}`).then(({ data }) => {
      let list = [];
      for (let i = 0; i < data.length; i++) {
        let chall = {};
        chall.title = data[i].workoutName;
        chall.date = data[i].createdDate.substring(0, 10);
        chall.color = this.colors[i % 10];
        chall.textColor = "rgb(42, 42, 133)";
        list.push(chall);
      }
      this.calendarOptions.events = list;
    });
  },
  created() {
    this.type = this.userType;
    if (this.type == "user") {
      this.nickName = this.loginUser.nickName;
    } else {
      this.nickName = this.guestUser;
    }
  },
  computed: {
    ...mapGetters(["loginUser", "guestUser", "userType"]),
  },
  components: {
    FullCalendar,
  },
  data() {
    return {
      nickName: null,
      type: "",
      w_name: "",
      w_cnt: "",
      set_cnt: "",
      date: "",
      isShow: false,
      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: "dayGridMonth",
        dateClick: this.handleDateClick,
        events: [],
      },
      colors: [
        "#ffb3b3",
        "#ffffb3",
        "#ecffb3",
        "#b3ffec",
        "#b3ecff",
        "#b3c6ff",
        "#ffb3ec",
        "#ffb3c6",
        "#cce2cb",
        "#ffd9b3",
      ],
    };
  },
  methods: {
    handleDateClick: function (arg) {
      if (this.loginUser.nickName == this.nickName) {
        this.isShow = true;
        this.date = arg.dateStr;
      }
    },
    save() {
      const workout = {
        nickName: this.loginUser.nickName,
        workoutName: this.w_name,
        workoutCnt: this.w_cnt,
        workoutSetCnt: this.set_cnt,
        createdDate: this.date,
      };
      console.log(workout);
      http.post("/workout", workout).then(() => {
        window.location.href = "http://localhost:8080/mypage/calendar";
      });
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 30px;
  margin-bottom: 30px;
  text-align: center;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.title {
  margin-top: 50px;
  margin-bottom: 50px;
  display: inline-flex;
}
.fc-col-header-cell-cushion {
  color: black !important;
}
.fc-day-sun a {
  color: red;
  text-decoration: none;
}
.fc-toolbar-title {
  font-size: 10px !important;
}
.calendar {
  height: 100%;
}
</style>
