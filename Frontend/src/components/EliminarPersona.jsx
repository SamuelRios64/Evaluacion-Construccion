import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/axiosConfig";

// Eliminar un tipo
const EliminarPersona = () => {

    // Estados
  const { id } = useParams();
  const [persona, setPersona] = useState("");
  const navigate = useNavigate();

  // Carga de datos
  useEffect(() => {
    const fetchTipo = async () => {
      try {
        const response = await api.get(`personas/${id}`);
        setPersona(response.data.nombre);
      } catch (error) {
        console.error("Error al obtener la persona:", error);
      }
    };
    fetchTipo();
  }, [id]);

  // Envio peticion al Backend
  const handleDelete = async () => {
    try {
      await api.delete(`personas/${id}`);
      navigate("/personas");
    } catch (error) {
      console.error("Error al eliminar la persona:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3>Eliminar Persona</h3>
      <p>¿Seguro que deseas eliminar la siguiente persona: <strong>{persona}</strong>?</p>
      <button className="btn btn-danger me-2" onClick={handleDelete}>
        Sí, eliminar
      </button>
      <button className="btn btn-secondary" onClick={() => navigate("/personas")}>
        Cancelar
      </button>
    </div>
  );
};

export default EliminarPersona;
