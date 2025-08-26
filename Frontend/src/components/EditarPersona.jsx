import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/axiosConfig";

// Editar un tipo
const EditarPersona = () => {
  // Estados
  const { id } = useParams();
  const [cargo, setCargo] = useState("");
  const navigate = useNavigate();

  // Carga de datos
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

  // Enviar forumulario
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log("Datos a enviar: " + id + cargo);
      const datos = {
        idTipo: id,
        nombre: cargo,
      };
      await api.put(`/tipos`, datos);
      navigate("/tipos");
    } catch (error) {
      console.error("Error al editar tipo:", error);
    }
  };

  return (
    // Formulario
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

        {/* Botones */}
        <div className="container mt-4">
          <button className="btn btn-success me-2" type="submit">
            Guardar
          </button>
          <button
            className="btn btn-secondary"
            onClick={() => navigate("/tipos")}
          >
            Cancelar
          </button>
        </div>
      </form>
    </div>
  );
};

export default EditarPersona;
