import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../pages/Login";
import Navegacion from "../components/Navegacion";
import Personas from "../pages/Personas";
import Tipos from "../pages/Tipos";
import Usuarios from "../pages/Usuarios";
import AgregarTipo from "../components/AgregarTipo";
import EditarTipo from "../components/EditarTipo";
import EliminarTipo from "../components/EliminarTipo";

function AppRoutes() {
  return (
    <div className="container">
      <BrowserRouter>
        <Navegacion />
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/personas" element={<Personas />} />
          <Route exact path="/tipos" element={<Tipos />} />
          <Route exact path="/usuarios" element={<Usuarios />} />
          <Route exact path="/tipos/agregar" element={<AgregarTipo />} />
          <Route exact path="/tipos/editar/:id" element={<EditarTipo />} />
          <Route exact path="/tipos/eliminar/:id" element={<EliminarTipo />} />
          <Route exact path="*" element={<h1>404 - Página no encontrada</h1>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default AppRoutes;
