import { createContext, useReducer, useState } from "react";

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
            console.log('Efetuando login da aplicação');
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

    const value = useReducer(applicationReducer, userData)

    return(
        <UserContext.Provider>
            { children }
        </UserContext.Provider>
    );
}
