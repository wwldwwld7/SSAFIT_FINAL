import Axios from "axios";

export default Axios.create({
  baseURL: "http//localhost:9999/ssafit",
  headers: {
    "Content-type": "application/json",
  },
});
