import { useState, useContext } from 'react';
import BaseInput from '../../components/BaseInput';
import SubmitButton from '../../components/SubmitButton';
import LoadingButton from '../../components/LoadingButton';
import { AuthContext } from '../../contexts/AuthContext';
import './login.css';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';

function Login() {

  const[ userName, setUsername ] = useState('');
  const[ pass, setPass ] = useState('');
  const[ loading, setLoading ] = useState(false);

  const{ user, login } = useContext(AuthContext);

  const navigate = useNavigate();

  async function handleLogin (e) {
    e.preventDefault();
    if(userName === '' || pass === ''){
      toast.error('Informe todos os campos!');
      return;
    }

    setLoading(true);
    await login(userName, pass);
    setLoading(false);
    navigate('/dashboard');

  }

  return (
    <div className='login-page'>
        <form className="login-card" onSubmit={ handleLogin }>
            <h1>MyBills</h1>
            <BaseInput 
              labelText="Nome" 
              type="text" 
              placeHolder="Digite seu nome" 
              changeState={setUsername}
            />
            <BaseInput 
              labelText="Senha"
              type="password" 
              placeHolder="*******" 
              changeState={setPass}
            />
            {
              loading ?
              (
                <LoadingButton />    
              ) : (
                <SubmitButton text="Entrar" />
              )
            }
            
            <span>
            <a href='/register'> Ainda não possui cadastro? se cadastre aqui</a>
            </span>
        </form>
    </div>
  )
}

export default Login