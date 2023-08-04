import { Routes, Route } from 'react-router-dom';
import Login from '../pages/Login';
import Home from '../pages/Home';
import Error from '../pages/Error';
import Register from '../pages/Register';

function RoutesApp() {
  return (
    <Routes>
        <Route path='/' element={ <Login /> } /> 
        <Route path='/register' element={ <Register /> } />
        <Route path="/dashboard" element={ <Home /> } /> 
        <Route path='*' element={ <Error /> } />
    </Routes>
  )
}

export default RoutesApp