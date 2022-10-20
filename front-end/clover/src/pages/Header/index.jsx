import React, { Profiler } from "react";

import './style.css';

// import logo from '../../../../assets/image/logo.png';
// import logo from '../../../../icons-react/scr/icons/ProfileFilled';

// import { BsCart2 } from "react-icons/ai";
// import { IoPersonSharp } from "react-icons/io";
import { NavLink } from "react-router-dom";

import cloverLogo from '../../assets/image/logo.png'
import iconPerson from '../../assets/image/person.png'
import carrinho from '../../assets/image/carrinho.png'
import lupa from '../../assets/image/lupa.png'

// import { BsPerson } from "react-icons/ai";


function Header(){
    return(
        //     <>
        // <header id="header">
        //     <div className="principal">
        //         <div className="pesquisa">
        //             <div className="input-icons">
        //                 <i className="fa fa-user icons">
        //                 </i>
        //                 <input className="input-field" type="search" />
        //             </div>

        //         </div>
        //         <div>
                
        //             <a id="logo" href=""><img classNameName="logo" src={logo} alt="" /></a>
        //         </div>
        //         <div className="controles">
        //             <div>
        //                 <a href="">
        //                     <span className="icon">
        //                        <IoPersonSharp/>
        //                     </span>
        //                     <span className="text">Minha conta</span>
        //                 </a>
        //             </div>
        //             <div>
        //                 <a href="">
        //                     <span className="icon">
        //                         <IoPersonSharp/>
        //                     </span>
        //                     <span className="text"></span>
        //                 </a>
        //             </div>
        //         </div>

        //     </div>
        //     <nav id="nav" className="navegation">
        //         <button aria-label="Abrir Menu" id="btn-mobile" aria-haspopup="true" aria-controls="menu" aria-expanded="false">Menu
        //     <span id="hamburger"></span>
        // </button>
        //         <ul id="menu" role="menu">
        //             <li id="contaMobile" className="list active">
        //                 <span className="icon">
        //                     <IoPersonSharp/>
        //                 </span>
        //                 <a href="./CadastroLogin">
        //                     <span className="text">Minha conta</span></a>
                       
        //             </li>
        //             <li id="carrinhoMobile" className="list">
        //                 <a href="">
        //                     <span className="icon">
        //                         <IoPersonSharp/>
        //                     </span>
        //                     <span className="text">Carrinho</span>
        //                 </a>
        //             </li>
        //             <li className="list"><a href="/">Vestuario</a></li>
        //             <li className="list"><a href="/">Acessórios</a></li>
        //             <li className="list"><a href="/">Colecionaveis</a></li>
        //             <li className="list"><a href="/">Decoração</a></li>
        //         </ul>
        //     </nav>
        // </header>
        //     </>

        <header id="header">
        <div className="principal">
          <div className="pesquisa">
            <div className="input-icons">
              <input className="input-field" type="search" />
              {/* <img src={lupa} alt="" /> */}
            </div>
          </div>
          <div>
            <NavLink id="logo" to="/">
              <img className="logo" src={cloverLogo} alt="" />
            </NavLink>
          </div>
          <div className="controles">
            <div>
              <NavLink href="">
                <span className="icon">
                  <img src={iconPerson} alt="" />
                </span>
                <span className="text">Minha conta</span>
              </NavLink>
            </div>
            <div>
              <NavLink href="">
                <span className="icon">
                  <img src={carrinho} alt="" />
                </span>
                <span className="text"></span>
              </NavLink>
            </div>
          </div>
        </div>
        <nav id="nav" className="navegation">
          <button
            aria-label="Abrir Menu"
            id="btn-mobile"
            aria-haspopup="true"
            aria-controls="menu"
            aria-expanded="false"
          >
            Menu
            <span id="hamburger"></span>
          </button>
          <ul id="menu" role="menu">
            <li id="contaMobile" className="list active">
              <span className="icon">
                <img src={iconPerson} alt="" />
              </span>
              <a href="./CadastroLogin">
                <span className="text">Minha conta</span>
              </a>
            </li>
            <li id="carrinhoMobile" className="list">
              <NavLink href="">
                <span className="icon">
                <img src={carrinho} alt="" />
                </span>
                <span className="text">Carrinho</span>
              </NavLink>
            </li>
            <li className="list">
              <a href="/">Vestuario</a>
            </li>
            <li className="list">
              <a href="/">Acessórios</a>
            </li>
            <li className="list">
              <a href="/">Colecionaveis</a>
            </li>
            <li className="list">
              <a href="/">Decoração</a>
            </li>
          </ul>
        </nav>
      </header>
    );
}

export default Header;