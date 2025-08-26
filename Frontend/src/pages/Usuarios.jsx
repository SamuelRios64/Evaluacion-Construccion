import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";

const Usuarios = () => {
  const [personas, setPersonas] = useState([]);
  const navigate = useNavigate();

  // Obtener personas del backend
  useEffect(() => {
    const fetchPersonas = async () => {
      try {
        const response = await api.get("/usuarios");
        setPersonas(response.data);
      } catch (error) {
        console.error("Error al obtener usuarios:", error);
      }
    };
    fetchPersonas();
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Gestión de Usuarios</h2>
      <button
        className="btn btn-success mb-3"
        onClick={() => navigate("/personas/agregar")}
      >
        Agregar Usuario
      </button>
      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Usuario</th>
            <th>Contraseña</th>
            <th>Persona</th>
            <th>Tipo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {personas.map((persona) => (
            <tr key={persona.idUsuario}>
              
              <td>{persona.idUsuario}</td>
              <td>{persona.usuario}</td>
              <td>{persona.contraseña}</td>
              <td>{persona?.idPersona?.nombre}</td>
              <td>{persona?.tipo?.nombre}</td>
              <td>
                <button
                  className="btn btn-primary btn-sm me-2"
                  onClick={() => navigate(`/usuarios/editar/${persona.idUsuario}`)}
                >
                  Modificar
                </button>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => navigate(`/usuarios/eliminar/${persona.idUsuario}`)}
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

export default Usuarios;;
