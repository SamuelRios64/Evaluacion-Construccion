import { Route, Routes } from 'react-router-dom'
import Login from '../pages/Login'
import Dueños from '../pages/Dueños'
import Mascotas from '../pages/Mascotas'
import Navegacion from '../components/Navegacion'

function AppRoutes() {
  return (
    <>
        <Navegacion/>
        <Routes>
            <Route exact path='/login' element={<Login/>}/>
            <Route exact path='/dueños' element={<Dueños/>}/>
            <Route exact path='/mascotas' element={<Mascotas/>}/>
            <Route path="*" element={<h1>404 - Página no encontrada</h1>} />
        </Routes>
    </>
  )
}

export default AppRoutes