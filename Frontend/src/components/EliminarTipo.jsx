import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/axiosConfig";

// Eliminar un tipo
const EliminarTipo = () => {

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

  // Envio peticion al Backend
  const handleDelete = async () => {
    try {
      await api.delete(`tipos/${id}`);
      navigate("/tipos");
    } catch (error) {
      console.error("Error al eliminar tipo:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3>Eliminar Tipo</h3>
      <p>¿Seguro que deseas eliminar el tipo con cargo: <strong>{cargo}</strong>?</p>
      <button className="btn btn-danger me-2" onClick={handleDelete}>
        Sí, eliminar
      </button>
      <button className="btn btn-secondary" onClick={() => navigate("/tipos")}>
        Cancelar
      </button>
    </div>
  );
};

export default EliminarTipo;
