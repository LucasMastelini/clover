import React from 'react';
import ReactDOM from 'react-dom/client';
import './assets/css/index.css';
import App from './App';
import { BrowserRouter, Route } from 'react-router-dom';
import Router from './routes/Router';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
    <Router/>
    </BrowserRouter>
  </React.StrictMode>
  
);
