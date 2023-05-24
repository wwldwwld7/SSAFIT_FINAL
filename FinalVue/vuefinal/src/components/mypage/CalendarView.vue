<!-- 식단관리 -->
<template>
  <div class="container">
    <FullCalendar :options="calendarOptions" />
    <v-app>
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
    // this.$refs.calendar.checkChange();;
    http.get(`/workout/my/${this.loginUser.nickName}`).then(({ data }) => {
      let list = [];
      data.forEach((d) => {
        let chall = {};
        chall.title = d.workoutName;
        chall.date = d.createdDate.substring(0, 10);
        list.push(chall);
      });
      // console.log(list[0]);
      this.calendarOptions.events = list;
    });
  },
  created() {},
  computed: {
    ...mapGetters(["loginUser"]),
  },
  components: {
    FullCalendar, // make the <FullCalendar> tag available
  },
  data() {
    return {
      guest: "",
      w_name: "",
      w_cnt: "",
      set_cnt: "",
      date: "",
      isShow: false,
      // workout: [],
      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: "dayGridMonth",
        dateClick: this.handleDateClick,
        events: [],
      },
    };
  },
  methods: {
    handleDateClick: function (arg) {
      // console.log(arg);
      this.isShow = true;
      this.date = arg.dateStr;
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
        // this.$router.push("/mypage/calendar");
        window.location.href = "http://localhost:8080/mypage/calendar";
      });
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 50px;
}
.fc-col-header-cell-cushion {
  color: black !important;
}
/* --fc-event-bg-color //등록요소들 배경 */
.fc-day-sun a {
  color: red;
  text-decoration: none;
}
</style>
