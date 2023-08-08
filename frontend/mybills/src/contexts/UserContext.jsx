import { createContext, useReducer, useState } from "react";
import apiService from "../services/apiService";

const userData = {
    id: '',
    name: '',
    imgUrl: '',
    balance: '',
    bills: [],
    acessToken: ''
}

const applicationReducer = (state, action) => {
    switch(action.type) {
        case 'login':
            let userLoginDTO = action.payload;
            apiService.post('login', {
                data: {
                    userName: userLoginDTO.username,
                    pass: userLoginDTO.pass
                }
            }).then((promisse) => {
                console.log(promisse.data)
            }).catch((error) => {
                console.log(error);
            });
            return{
                ...state, //mantem o estado anterior
                //Realiza a ação desejada
            }
    }
}

export const UserContext = createContext({});

/**
 * Irá prover os dados do usuário para a aplicação
 */
export const UserProvider = ({ children }) => {

    //Disponibilizando reducer para a aplicação poder utilizar
    const value = useReducer(applicationReducer, userData)

    return(
        <UserContext.Provider value={{ value }}>
            { children }
        </UserContext.Provider>
    );
}
