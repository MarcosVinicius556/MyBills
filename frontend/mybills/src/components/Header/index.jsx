import { useState } from 'react';
import { Link } from 'react-router-dom';
import { AiOutlineMenuUnfold, AiOutlineMenuFold } from 'react-icons/ai';
import './header.css';

function Header() {
    const[ fullMenu, setFullMenu ] = useState(false);

  function handleExpandMenu() {
    setFullMenu(!fullMenu);
  }

  return (
    <div className={ fullMenu ? "block-background" : "" }>
      <header className={fullMenu ? `expand-container` : ''}>
          {fullMenu 
          ? (<AiOutlineMenuFold size={45} onClick={handleExpandMenu} className='change-menu-btn'/>) 
          : (<AiOutlineMenuUnfold size={45} onClick={handleExpandMenu} className='change-menu-btn'/>) 
          }
          
          <div class={`header-container ${fullMenu ? 'show-container' : ''}`}>
              <h1>My Bills</h1>
              <img src="" alt="foto do usuário" />
              <div class="header-options">
                  <Link to="/dashboard">Home</Link>
                  <Link to="/profile">Configurações de perfil</Link>
                  <Link to="/show-bills">Visualizar gastos</Link>
                  <Link to="/add-bills">Cadastrar um novo gasto</Link>
              </div>
          </div>
      </header>
    </div>
  )
}

export default Header