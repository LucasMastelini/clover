import React from "react";
import { useState } from "react";
import { AiOutlineCloudDownload, AiOutlineCloudUpload } from "react-icons/ai";
import { FiLogOut } from "react-icons/fi";
import { FaTshirt } from "react-icons/fa";
import { UserData } from "./Data";
import logoClover from "../../assets/image/logo.png";
import BarCharts from "./components/BarCharts";
import LineCharts from "./components/LineCharts";
import PieCharts from "./components/PieCharts";
import { useNavigate } from "react-router-dom";

import "./style.css";
import api from "../../Api/api";
import { useEffect } from "react";

export default function TelaAdmin() {
  const navegar = useNavigate();
  const [faturamento, setFaturamento] = useState();
  const [admin , setAdmin] = useState(false);


  useEffect(() => {
    var array =[];
    api.get('/admin/dashboard')
      .then((res) => {
        console.log(res.data);
        setFaturamento(res.data.percentualFaturamentoPorRegiao.lista);
        for(let i = 0; i < res.data.length; i++) {
          array.push(res.data[i])
        }
      })
      .catch((err) => {
        console.log(err);
      })


      console.log(array.length);
      console.log(array.lista);
      setAdmin(localStorage.getItem('isLogado'));
  }, [])
  console.log(faturamento?.map((data) => data.regiao));




  const [dados] = useState({
    labels: faturamento?.map((data) => data.regiao),
    datasets: [
      {
        label: "Percentual faturado",
        data: faturamento?.map((data) => data.percentualFaturamentoPorRegiao),
        backgroundColor: [
          "#35DAF0",
          "#510090",
          "#37003D",
          "#082166",
          "#C468CD",
        ],
        borderColor: "black",
        borderWidth: 1,
        color: "#fff",
      },
    ],
  });

  function sair() {

    const values = {
      id: localStorage.getItem('id'),
      nome: localStorage.getItem('nome'),
      email: localStorage.getItem('email')
    }

    api.post('/logoff', values)
      .then((res) => {
        console.log(res);
        localStorage.clear();
      })
      .catch((err) => {
        console.log(err)
      })
  }

  if (admin ) {
    return (
      <>
        <div className="container-admin">
          <div className="header-admin">
            <div className="container-arquivos">
              <button className="upload-button">
                <a href="http://localhost:3000/" target="_blank" rel="noopener noreferrer" >
                  <AiOutlineCloudDownload />
                  <h3>Download</h3>
                </a>
              </button>
              <button className="upload-button">
                <a href="http://localhost:3001/" target="_blank" rel="noopener noreferrer">
                  <AiOutlineCloudUpload />
                  <h3>Upload</h3>
                </a>
              </button>
            </div>
            <img src={logoClover} alt="" />
            <button className="upload-button" onClick={sair}>
              <h3>Sair</h3>
              <FiLogOut />
            </button>
          </div>
          <div className="body-admin">
            <div className="topo-body">
              <FaTshirt />
              <h3>
                Quantidade de produtos total: <span>20</span>
              </h3>
            </div>
            <div className="body-charts">
              <div className="chart">
                <BarCharts chartData={dados} />
              </div>
              <div className="chart">
                <LineCharts chartData={dados} />
              </div>
              <div className="chart">
                <PieCharts chartData={dados} />
              </div>
            </div>
          </div>
          {/* <div className="area-upload">
          <AreaUpload />
        </div> */}
        </div>
      </>
    );
  } else{ navegar("/")}

}
