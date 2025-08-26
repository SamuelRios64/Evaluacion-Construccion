import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/axiosConfig";

const EditarTipo = () => {
  const { id } = useParams();
  const [cargo, setCargo] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTipo = async () => {
      try {
        const response = await api.get(`tipos/${id}`);
        setCargo(response.data.nombre);
      } catch (error) {
        console.error("Error al obtener tipo:", error);
      }
    };
    fetchTipo();
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.put(`/tipos`, { id, cargo } );
      navigate("/tipos");
    } catch (error) {
      console.error("Error al editar tipo:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3>Editar Tipo</h3>
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
        <button className="btn btn-primary" type="submit">
          Guardar Cambios
        </button>
      </form>
    </div>
  );
};

export default EditarTipo;
