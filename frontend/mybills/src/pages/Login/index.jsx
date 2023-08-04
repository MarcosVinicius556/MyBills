import { useState } from 'react';
import BaseInput from '../../components/BaseInput';
import SubmitButton from '../../components/SubmitButton';
import './login.css';

function Login() {

  const[ userName, setUsername ] = useState('');
  const[ pass, setPass ] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    console.log(`Dados: ${ userName }, ${ pass } `);
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
            <SubmitButton text="Entrar" />
            <span>
            <a href='/register'> Ainda não possui cadastro? se cadastre aqui</a>
            </span>
        </form>
    </div>
  )
}

export default Login