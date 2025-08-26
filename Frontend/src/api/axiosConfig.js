import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/garras/api/v1", // Ajusta a tu backend
});

export default api;