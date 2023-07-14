import './login.css';

function Login() {
  return (
    <div className='login-page'>
        <form className="login-card">
                <h1>MyBills</h1>
            <div className="input-box">
                <label>Nome</label>
                <input type="text" name="nome" />
            </div>
            <div className="input-box">
                <label>Senha</label>
                <input type="password" name="senha"/>
            </div>

            <input type="submit" value="Login" />
            <span>
                Ainda não possui cadastro? se cadastre <a href='/cadastro'>aqui</a>
            </span>
        </form>
    </div>
  )
}

export default Login