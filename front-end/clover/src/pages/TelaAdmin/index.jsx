import React from 'react';
import { useState } from 'react';
import { AiOutlineCloudDownload } from 'react-icons/ai';
import { FiLogOut } from 'react-icons/fi';
import { FaTshirt } from "react-icons/fa";
import { UserData } from './Data';
import logoClover from '../../assets/image/logo.png';
import BarCharts from './components/BarCharts';
import LineCharts from './components/LineCharts';
import PieCharts from './components/PieCharts';

import './style.css'
import AreaUpload from './components/AreaUpload';

export default function TelaAdmin() {

    const [userData] = useState({
        labels: UserData.map((data) => data.year),
        datasets: [{
            label: "Users Gained",
            data: UserData.map((data) => data.userGain),
            backgroundColor: [
                "#35DAF0",
                "#510090",
                "#37003D",
                "#082166",
                "#C468CD"
            ],
            borderColor: "black",
            borderWidth: 1,
            color: "#fff",
        }]
    })

  return (
    <>
        <div className="container-admin">
            <div className="header-admin">
                <button className="upload-button">
                    <AiOutlineCloudDownload/>
                    <h3>Gerar Arquivo</h3>
                </button>
                <img src={logoClover} alt="" />
                <button className="upload-button">
                    <h3>Sair</h3>
                    <FiLogOut/>
                </button>
            </div>
            <div className="body-admin">
                <div className="topo-body">
                    <FaTshirt/>
                    <h3>Quantidade de produtos total: <span>20</span></h3>
                </div>
                <div className="body-charts">
                    <div className="chart">
                        <BarCharts chartData={userData}/>
                    </div>
                    <div className="chart">
                        <LineCharts chartData={userData}/>
                    </div>
                    <div className="chart">
                        <PieCharts chartData={userData}/> 
                    </div>
                </div>
            </div>
            <div className="area-upload">
                <AreaUpload/>
            </div>
        </div>
    </>
  )
}
