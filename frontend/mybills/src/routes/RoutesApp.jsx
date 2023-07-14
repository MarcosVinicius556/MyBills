import { Routes, Route } from 'react-router-dom';
import Login from '../pages/Login';
import Home from '../pages/Home';
import Error from '../pages/Error';

function RoutesApp() {
  return (
    <Routes>
        <Route path='/' element={ <Home /> } /> 
        <Route path='/login' element={ <Login /> } /> 
        <Route path='*' element={ <Error /> } />
    </Routes>
  )
}

export default RoutesApp