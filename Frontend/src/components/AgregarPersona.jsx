import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

const AgregarPersona = () => {
  const [idPersona, setIdPersona] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellido, setaApellido] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        const persona = {
            idPersona: idPersona,
            nombre: nombre,
            apellido: apellido
        }
      console.log("Persona a agregar: " + persona);
      await api.post("/personas", persona);
      navigate("/personas");
    } catch (error) {
      console.error("Error al agregar a la persona:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3>Agregar Persona</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">ID</label>
          <input
            type="number"
            className="form-control"
            value={idPersona}
            onChange={(e) => setIdPersona(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Nombre</label>
          <input
            type="text"
            className="form-control"
            value={nombre}
            onChange={(e) => setNombre(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Apellido</label>
          <input
            type="text"
            className="form-control"
            value={apellido}
            onChange={(e) => setaApellido(e.target.value)}
            required
          />
        </div>
        <button className="btn btn-success m-2" type="submit">
          Guardar
        </button>
        <button
          className="btn btn-secondary"
          onClick={() => navigate("/personas")}
        >
          Cancelar
        </button>
      </form>
    </div>
  );
};

export default AgregarPersona;
