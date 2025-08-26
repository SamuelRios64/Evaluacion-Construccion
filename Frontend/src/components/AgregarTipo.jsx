import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

const AgregarTipo = () => {
  const [cargo, setCargo] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post("/tipos", { cargo });
      navigate("/tipos");
    } catch (error) {
      console.error("Error al agregar tipo:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3>Agregar Tipo</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Cargo</label>
          <input
            type="text"
            className="form-control"
            value={cargo}
            onChange={(e) => setCargo(e.target.value)}
            required
          />
        </div>
        <button className="btn btn-success m-2" type="submit">
          Guardar
        </button>
        <button
          className="btn btn-secondary"
          onClick={() => navigate("/tipos")}
        >
          Cancelar
        </button>
      </form>
    </div>
  );
};

export default AgregarTipo;
