// import './login.css';

function Register() {
  return (
    <div className='login-page'>
        <form className="login-card">
                <h1>MyBills</h1>
            <div className="input-box">
                <label>Email</label>
                <input type="email" name="email" />
            </div>
            <div className="input-box">
                <label>Nome</label>
                <input type="text" name="nome" />
            </div>
            <div className="input-box">
                <label>Senha</label>
                <input type="password" name="senha"/>
            </div>

            <input type="submit" value="Cadastrar" className="login-btn"/>
            <span>
            <a href='/'> Já possui cadastro? Faça login! </a>
            </span>
        </form>
    </div>
  )
}

export default Register