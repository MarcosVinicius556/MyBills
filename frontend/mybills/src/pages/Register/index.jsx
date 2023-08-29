import { useContext } from "react";
import { useForm } from 'react-hook-form';
import { AuthContext } from "../../contexts/AuthContext";
import BaseInput from "../../components/BaseInput";
import SubmitButton from "../../components/SubmitButton";
import { zodResolver } from '@hookform/resolvers/zod';

import { z } from 'zod';

const schemaValidation = z.object({
    email: z.string()
            .email('Digite um email válido')
            .max(64, 'O tamanho máximo do email deve ser 64!')
            .nonempty('O campo de email é obrigatório!'),
    name: z.string()
           .max(128, 'O tamanho máximo do nome deve ser 128!')
           .nonempty('O campo de nome é obrigatório!'),
    password: z.string()
               .max(64, 'O tamanho máximo deve ser 64!')
               .nonempty('O campo de senha é obrigatório')
});

function Register() {

  const{ userRegister } = useContext(AuthContext);
  const{ register, handleSubmit, formState: { errors } } = useForm({
    resolver: zodResolver(schemaValidation)
  });

  const handleSignUp = (data) => {
    let userLoginDTO = {
      username: data.email, 
      name: data.username, 
      password: data.password
    }

    let isRegistered =  userRegister(userLoginDTO);
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
              register={register('email')}
            />
            {errors.email && (<p className="error-message">{errors.email.message}</p>)}
            
            <BaseInput 
              labelText="Nome" 
              type="text" 
              placeHolder="Digite seu nome"
              register={register('name')}
              />
            {errors.name && (<p className="error-message">{errors.name.message}</p>)}
            
            <BaseInput 
              labelText="Senha" 
              type="password" 
              placeHolder="******" 
              register={register('password')}
              />
            {errors.password && (<p className="error-message">{errors.password.message}</p>)}

            <SubmitButton text="Cadastrar" />
            <span>
            <a href='/'> Já possui cadastro? Faça login! </a>
            </span>
        </form>
    </div>
  )
}

export default Register