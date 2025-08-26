import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

// Página de Tipos
const Tipos = () => {

  // Estados
  const [tipos, setTipos] = useState([]);
  const navigate = useNavigate();

  // Obtener tipos del backend
  useEffect(() => {
    const fetchTipos = async () => {
      try {
        const response = await api.get("/tipos");
        setTipos(response.data);
      } catch (error) {
        console.error("Error al obtener tipos:", error);
      }
    };
    fetchTipos();
  }, []);

  return (

    // Tabla de Tipos, con sus respectivos botones y registros

    <div className="container mt-4">
      <h2 className="mb-3">Gestión de Tipos</h2>
      <button
        className="btn btn-success mb-3"
        onClick={() => navigate("/tipos/agregar")}
      >
        Agregar Tipo
      </button>
      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Cargo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {tipos.map((tipo) => (
            <tr key={tipo.id}>
              <td>{tipo.idTipo}</td>
              <td>{tipo.nombre}</td>
              <td>
                <button
                  className="btn btn-primary btn-sm me-2"
                  onClick={() => navigate(`/tipos/editar/${tipo.idTipo}`)}
                >
                  Modificar
                </button>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => navigate(`/tipos/eliminar/${tipo.idTipo}`)}
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

export default Tipos;
