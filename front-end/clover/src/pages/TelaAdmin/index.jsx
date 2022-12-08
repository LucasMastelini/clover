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
import api from "../../Api/api"

import "./style.css";
import { useNavigate } from "react-router-dom";

export default function TelaAdmin() {
  const navegar = useNavigate();
  const [userData] = useState({
    labels: UserData.map((data) => data.year),
    datasets: [
      {
        label: "Users Gained",
        data: UserData.map((data) => data.userGain),
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

  const extensao = "csv"

  function baixarArquivo(event) {
    api.get(`gravar-arquivos/${extensao}`, event).then((res) => {
            console.log(res);
    })
    .catch((err) => {
        console.log(err);
    });
  }

  function sair() {

    const values = {
      id: localStorage.getItem('id'),
      nome: localStorage.getItem('nome'),
      email: localStorage.getItem('email')
    }

    api.post('/logoff', values)
      .then((res) => {
        // console.log(res);
        localStorage.clear();
        navegar("/")
      })
      .catch((err) => {
        console.log(err)
      })
  }

  return (
    <>
      <div className="container-admin">
        <div className="header-admin">
          <div className="container-arquivos">
            <button className="upload-button">
                <a href="" target="_blank" rel="noopener noreferrer" >
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
              <BarCharts chartData={userData} />
            </div>
            <div className="chart">
              <LineCharts chartData={userData} />
            </div>
            <div className="chart">
              <PieCharts chartData={userData} />
            </div>
          </div>
        </div>
        {/* <div className="area-upload">
          <AreaUpload />
        </div> */}
      </div>
    </>
  );
}