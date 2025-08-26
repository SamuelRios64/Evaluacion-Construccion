import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

const Personas = () => {
  const [personas, setPersonas] = useState([]);
  const navigate = useNavigate();

  // Obtener tipos del backend
  useEffect(() => {
    const fetchPersonas = async () => {
      try {
        const response = await api.get("/personas");
        setPersonas(response.data);
      } catch (error) {
        console.error("Error al obtener personas:", error);
      }
    };
    fetchPersonas();
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Gestión de Personas</h2>
      <button
        className="btn btn-success mb-3"
        onClick={() => navigate("/tipos/agregar")}
      >
        Agregar Personas
      </button>
      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {personas.map((persona) => (
            <tr key={persona.idPersona}>
              <td>{persona.idPersona}</td>
              <td>{persona.nombre}</td>
              <td>{persona.apellido}</td>
              <td>
                <button
                  className="btn btn-primary btn-sm me-2"
                  onClick={() => navigate(`/tipos/editar/${tipo.id}`)}
                >
                  Modificar
                </button>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => navigate(`/tipos/eliminar/${tipo.id}`)}
                >
                  Eliminar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Personas;
