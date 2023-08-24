import { useState, useContext } from "react";
import { AuthContext } from "../../contexts/AuthContext";
import BaseInput from "../../components/BaseInput";
import SubmitButton from "../../components/SubmitButton";

function Register() {

  const{ register } = useContext(AuthContext);
  const[ email, setEmail ] = useState('');
  const[ username, setUsername ] = useState('');
  const[ password, setPassword ] = useState('');

  const handleSignUp = (e) => {
    e.preventDefault();
    let userLoginDTO = {
      username: email, 
      name: username, 
      password: password
    }

    register(userLoginDTO);
  }

  return (
    <div className='login-page'>
        <form className="login-card" onSubmit={handleSignUp}>
            <h1>MyBills</h1>
            <BaseInput 
              labelText="Email" 
              type="email" 
              placeHolder="email@email.com" 
              changeState={setEmail}
            />
            <BaseInput 
              labelText="Nome" 
              type="text" 
              placeHolder="Digite seu nome" 
              changeState={setUsername}
            />
            <BaseInput 
              labelText="Senha" 
              type="password" 
              placeHolder="******" 
              changeState={setPassword}
            />
            <SubmitButton text="Cadastrar" />
            <span>
            <a href='/'> Já possui cadastro? Faça login! </a>
            </span>
        </form>
    </div>
  )
}

export default Register