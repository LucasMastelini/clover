import React, { Profiler } from "react";import './style.css';

import logo from '../../../../assets/image/logo.png';
import logo from '../../../../icons-react/scr/icons/ProfileFilled';

import { BsCart2 } from "react-icons/ai";
import { BsPerson } from "react-icons/ai";

function Header(){
    return(
            <>
        <header id="header">
            <div class="principal">
                <div class="pesquisa">
                    <div class="input-icons">
                        <i class="fa fa-user icons">
                        </i>
                        <input class="input-field" type="search" />
                    </div>

                </div>
                <div>
                
                    <a id="logo" href=""><img className="logo" src={logo} alt="" /></a>
                </div>
                <div class="controles">
                    <div>
                        <a href="">
                            <span class="icon">
                               <BsPerson></BsPerson>
                            </span>
                            <span class="text">Minha conta</span>
                        </a>
                    </div>
                    <div>
                        <a href="">
                            <span class="icon">
                                <BsCart2></BsCart2>
                            </span>
                            <span class="text"></span>
                        </a>
                    </div>
                </div>

            </div>
            <nav id="nav" class="navegation">
                <button aria-label="Abrir Menu" id="btn-mobile" aria-haspopup="true" aria-controls="menu" aria-expanded="false">Menu
            <span id="hamburger"></span>
        </button>
                <ul id="menu" role="menu">
                    <li id="contaMobile" class="list active">
                        <span class="icon">
                            <BsPerson></BsPerson>
                        </span>
                        <span class="text">Minha conta</span>
                    </li>
                    <li id="carrinhoMobile" class="list">
                        <a href="">
                            <span class="icon">
                                <BsCart2></BsCart2>
                            </span>
                            <span class="text">Carrinho</span>
                        </a>
                    </li>
                    <li class="list"><a href="/">Vestuario</a></li>
                    <li class="list"><a href="/">Acessórios</a></li>
                    <li class="list"><a href="/">Colecionaveis</a></li>
                    <li class="list"><a href="/">Decoração</a></li>
                </ul>
            </nav>
        </header>
            </>
    );
}

export default Header;