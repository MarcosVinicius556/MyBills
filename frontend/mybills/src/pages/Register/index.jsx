import { useContext } from "react";
import { useForm } from 'react-hook-form';
import { AuthContext } from "../../contexts/AuthContext";
import BaseInput from "../../components/BaseInput";
import SubmitButton from "../../components/SubmitButton";

function Register() {

  const{ userRegister } = useContext(AuthContext);
  const{ register, handleSubmit } = useForm();

  const handleSignUp = (e) => {
    e.preventDefault();
    let userLoginDTO = {
      username: email, 
      name: username, 
      password: password
    }

    let isRegistered =  register(userLoginDTO);
    if(!isRegistered) {
      setEmail
    }
  }

  return (
    <div className='login-page'>
        <form className="login-card" onSubmit={handleSubmit(handleSignUp)}>
            <h1>MyBills</h1>
            <BaseInput 
              labelText="Email" 
              type="email" 
              placeHolder="email@email.com" 
              { ...register('email')}
            />
            <BaseInput 
              labelText="Nome" 
              type="text" 
              placeHolder="Digite seu nome"
              { ...register('name')}
            />
            <BaseInput 
              labelText="Senha" 
              type="password" 
              placeHolder="******" 
              { ...register('password')}
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