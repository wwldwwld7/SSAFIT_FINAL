import Axios from "axios";

export default Axios.create({
  baseURL: "http://localhost:9999",
  headers: {
    "Content-type": "application/json",
  },
});
