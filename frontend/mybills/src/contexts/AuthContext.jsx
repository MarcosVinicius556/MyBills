import { createContext, useState } from "react";
import apiService from "../services/apiService";
import { toast } from 'react-toastify'
import { useNavigate } from 'react-router-dom';
import { HttpStatusCode } from "axios";

export const AuthContext = createContext({});

/**
 * Irá prover os dados do usuário para a aplicação
 */
export const AuthProvider = ({ children }) => {
    const navigate = useNavigate(); 
    const[ user, setUser ] = useState({});

    async function login(userName, pass) {
        let dataToSend = {
            userName: userName,
            password: pass,
        }
    
         await apiService.post('/login', dataToSend)
                  .then(async (promisse) => {
                        let obj = promisse.data;
                        let data = {
                            id: obj.id,
                            name: obj.name,
                            telephone: obj.telephone,
                            avatarImg: obj.avatarImg,
                            balance: obj.balance,
                            accesToken: obj.accesToken,
                            bills: obj.bills,
                        }
                        setUser(data);
                        toast.success(`Login efetuado com sucesso, Seja bem vindo ${ user.name }!`);
                    }).catch((error) => {
                        setUser(null);
                        if(error.response.status === 403) {
                            toast.error('Usuário ou senha inválidos!');
                        } else {
                            toast.error("Ocorreu um erro ao fazer o login!");
                            console.log(error);
                        }
                    });
    }

    async function userRegister(userLoginDTO) {
        let isRegistered =  false;
        await apiService.post('/users/register', userLoginDTO)
              .then((response) => {
                console.log(response);
                toast.success('Usuário cadastrado com sucesso!\n Você será redirecionado para o login em alguns segundos...');
                setTimeout(() => {
                    navigate('/');
                }, 6000);
                isRegistered = true;
              })
              .catch((error) => {
                if(error.response.status == HttpStatusCode.Conflict) {
                    toast.error('email já cadastrado');
                    isRegistered = false;
                    return;
                }

                toast.error(`Ocorreu um erro inesperado ao salvar o registro ${error}`);
                isRegistered = false;
              });
        return isRegistered;
    }

    return(
        <AuthContext.Provider value={{ 
            user,
            login,
            userRegister
            }}>
            { children }
        </AuthContext.Provider>
    );
}
